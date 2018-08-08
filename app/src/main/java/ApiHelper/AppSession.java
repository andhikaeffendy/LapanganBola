package ApiHelper;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSession {

    public final static String SHAREDKEY = "LapanganBola-session";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AppSession(Context mContext){
        sharedPreferences = mContext.getSharedPreferences(SHAREDKEY, Context.MODE_PRIVATE);
    }

    public void clearSession(){
        editor = sharedPreferences.edit();
        editor.clear().apply();
    }

    public String getData(String data){
        return sharedPreferences.getString(data, null);
    }

    public String getData(String data, String defaultValue){
        return sharedPreferences.getString(data, defaultValue);
    }

    public void setData(String data, String value){
        editor = sharedPreferences.edit();
        editor.putString(data, value);
        editor.apply();
    }

    public void deleteData(String data){
        editor = sharedPreferences.edit();
        editor.remove(data);
        editor.apply();
    }

    public void createSession(){

    }

    public Boolean isLogin(){
        return true;
    }
}
