/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.bodybyte;

import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.squareup.okhttp.ResponseBody;
import fixtures.bodybyte.models.ErrorException;
import java.io.IOException;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.PUT;

/**
 * An instance of this class provides access to all the operations defined
 * in ByteOperations.
 */
public interface ByteOperations {
    /**
     * The interface defining all the services for ByteOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ByteService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("byte/null")
        Call<ResponseBody> getNull();

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("byte/empty")
        Call<ResponseBody> getEmpty();

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("byte/nonAscii")
        Call<ResponseBody> getNonAscii();

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("byte/nonAscii")
        Call<ResponseBody> putNonAscii(@Body byte[] byteBody);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("byte/invalid")
        Call<ResponseBody> getInvalid();

    }
    /**
     * Get null byte value.
     *
     * @throws ErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the byte[] object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<byte[]> getNull() throws ErrorException, IOException;

    /**
     * Get null byte value.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getNullAsync(final ServiceCallback<byte[]> serviceCallback);

    /**
     * Get empty byte value ''.
     *
     * @throws ErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the byte[] object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<byte[]> getEmpty() throws ErrorException, IOException;

    /**
     * Get empty byte value ''.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getEmptyAsync(final ServiceCallback<byte[]> serviceCallback);

    /**
     * Get non-ascii byte string hex(FF FE FD FC FB FA F9 F8 F7 F6).
     *
     * @throws ErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the byte[] object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<byte[]> getNonAscii() throws ErrorException, IOException;

    /**
     * Get non-ascii byte string hex(FF FE FD FC FB FA F9 F8 F7 F6).
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getNonAsciiAsync(final ServiceCallback<byte[]> serviceCallback);

    /**
     * Put non-ascii byte string hex(FF FE FD FC FB FA F9 F8 F7 F6).
     *
     * @param byteBody Base64-encoded non-ascii byte string hex(FF FE FD FC FB FA F9 F8 F7 F6)
     * @throws ErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> putNonAscii(byte[] byteBody) throws ErrorException, IOException, IllegalArgumentException;

    /**
     * Put non-ascii byte string hex(FF FE FD FC FB FA F9 F8 F7 F6).
     *
     * @param byteBody Base64-encoded non-ascii byte string hex(FF FE FD FC FB FA F9 F8 F7 F6)
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> putNonAsciiAsync(byte[] byteBody, final ServiceCallback<Void> serviceCallback);

    /**
     * Get invalid byte value ':::SWAGGER::::'.
     *
     * @throws ErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the byte[] object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<byte[]> getInvalid() throws ErrorException, IOException;

    /**
     * Get invalid byte value ':::SWAGGER::::'.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> getInvalidAsync(final ServiceCallback<byte[]> serviceCallback);

}