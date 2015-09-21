function Generate-Client()
{
	$configFileName = "WebApiClient.config.json"

	$codeGenPkg = Get-Package -Filter "Vulcan.Rest.Generator.CSharp" | Sort { $_.Version } -Desc | Select -First 1
	$codeGenVersion = $codeGenPkg.Version.Version.ToString()
	$codeGenDir = ".\packages\Vulcan.Rest.Generator.CSharp.$codeGenVersion"
	$codeGenExe = Resolve-Path "$codeGenDir\Tools\autorest.exe"

	# Find config files
	$configs = ls "**\$configFileName"

	foreach ($config in $configs) 
	{
		$projectDir = $config.DirectoryName
		$configFilePath = $config.FullName

		Write-Debug "CodeGen:        $codeGenExe"
		Write-Debug "ProjectDir:     $projectDir"
		Write-Debug "ConfigFileName: $configFileName"
		Write-Debug "ConfigFilePath: $configFilePath"

		Write-Host "Generating client for: $configFilePath"

		#
		# Read Configuration from JSON
		#
		$configJson = Get-Content $configFilePath | Out-String | ConvertFrom-Json
		if ($configJson.Namespace) {
			$namespace= $configJson.Namespace
		}
		else {
			$namespace = $project.Properties.Item("RootNamespace").Value
		}
		if ($configJson.OutputFileName) {
			$outputName = $configJson.OutputFileName
		}
		else {
			$outputName = "WebApiClient.cs"
		}
		if ($configJson.SwaggerUrl) {
			$swaggerUrl = $configJson.SwaggerUrl
		}
		else {
			throw "SwaggerURL must be specified in the '$configFileName' file."
		}

		#
		# Execute Autorest 
		#
		$outputPath = Join-Path $projectDir $outputName

		# Backup last file
		If (Test-Path $outputPath) {
			# Clear-Content $outputPath
			$backupPath = "$outputPath.bak"
			Write-Debug "CodeGen found: backup to $backupPath"
			Move-Item $outputPath $backupPath -Force
		}


		&$codeGenExe -input $swaggerUrl -namespace $namespace -CodeGenerator Vulcan.CSharp -OutputDirectory $projectDir -OutputFileName $outputName
		
		if ($backupPath -ne $null) {
			if (Test-Path $outputPath) {
				# delete backup
				Write-Debug "CodeGen success: deleting backup"
				Remove-Item $backupPath
			}
			else {
				# move backup back
				Write-Debug "CodeGen failed: restoring from backup"
				Move-Item $backupPath $outputPath -Force
			}
		}
	}
}
Export-ModuleMember Generate-Client