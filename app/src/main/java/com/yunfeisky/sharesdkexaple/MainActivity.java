package com.yunfeisky.sharesdkexaple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*shareSDK*/
        ShareSDK.initSDK(this);
        /*sharesdk---*/
        editText=(EditText)findViewById(R.id.edt_text);
        Button button=(Button)findViewById(R.id.btn_ok);
        if(button!=null){
            button.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                if(editText!=null){
                    String txt=editText.getText().toString();
                    /*shareSDK*/
                    cn.sharesdk.onekeyshare.OnekeyShare oks = new cn.sharesdk.onekeyshare.OnekeyShare();
                    //关闭sso授权
                    oks.disableSSOWhenAuthorize();
                    // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
                    oks.setTitle("标题");
                    // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
                    oks.setTitleUrl("http://sharesdk.cn");
                    // text是分享文本，所有平台都需要这个字段
                    oks.setText(txt);
                    //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                    oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                    //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                    // url仅在微信（包括好友和朋友圈）中使用
                    oks.setUrl("http://sharesdk.cn");
                    // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                    oks.setComment("我是测试评论文本");
                    // site是分享此内容的网站名称，仅在QQ空间使用
                    oks.setSite("ShareSDK");
                    // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                    oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
                    oks.show(this);
                    /*sharesdk---*/
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        /*shareSdk*/
        ShareSDK.stopSDK(this);
        /*shareSdk---*/
        super.onDestroy();
    }
}
