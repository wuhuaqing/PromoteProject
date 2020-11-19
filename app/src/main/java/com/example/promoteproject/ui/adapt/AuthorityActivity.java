package com.example.promoteproject.ui.adapt;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;

import com.example.promoteproject.R;

import java.util.HashMap;
import java.util.List;

/**
 * 权限适配
 */
public class AuthorityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority);
    }


//    private void fileRequestPermision(final HashMap<String, String> strMap){
//        PermissionX.init(this).permissions(Manifest.permission.REQUEST_INSTALL_PACKAGES)
//                .onExplainRequestReason(new ExplainReasonCallback() {
//                    @Override
//                    public void onExplainReason(ExplainScope scope, List<String> deniedList) {
//                        String message = "安装新的版本，需要您的权限";
//                        scope.showRequestReasonDialog(deniedList,message,"允许","不允许");
//                    }
//                })
//                .request(new RequestCallback() {
//                    @Override
//                    public void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList) {
//                        if(allGranted){
//                            ToastUtil.show("权限通过");
//                            apkupdataNotice(strMap);
//                        }else {
//                            ToastUtil.show("权限被拒绝");
//                        }
//                    }
//                });
//
//    }
}