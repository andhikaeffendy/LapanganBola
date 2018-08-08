package ApiHelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("farmers/sign_in")
    Call<ResponseBody> farmersLogin(@Field("auth_token") String token,
                                    @Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("owners/sign_in")
    Call<ResponseBody> ownersLogin(@Field("auth_token") String token,
                                    @Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("owners")
    Call<ResponseBody> registerOwner(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String passwordConfirmation,
                                     @Field("email") String email);

    @FormUrlEncoded
    @POST("owners/forgot_password")
    Call<ResponseBody> forgotPasswordOwner(@Field("email") String email);

    @FormUrlEncoded
    @POST("owners/sign_out")
    Call<ResponseBody> signOutOwner(@Field("auth_token") String token);

    @FormUrlEncoded
    @GET("owners/profile_detail")
    Call<ResponseBody> detailProfileOwner(@Field("auth_token") String token);
}
