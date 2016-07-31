package com.mary.eventbusdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mary.eventbusdemo.bean.AdsInfo;
import com.mary.eventbusdemo.inter.ReqCallBack;
import com.mary.eventbusdemo.util.JsonUtil;
import com.mary.eventbusdemo.util.NetWorkManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private TextView tvTip;
    private Button btnRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * 初始化试图
     */
    private void initViews() {
        tvTip = (TextView) this.findViewById(R.id.id_tv_tip);
        btnRequest = (Button) this.findViewById(R.id.id_btn_request);

        btnRequest.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                request();
            }
        });

    }

    /**
     * 请求
     */
    private void request() {
        String actionUrl = "http://lszserver.duapp.com/LSZServer/AdsServlet";
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("adsKey", "lsz1108");
        paramsMap.put("adsType", "lsz_chargeback_ads");
        NetWorkManager.getInstance(this).requestAsyn(actionUrl, NetWorkManager.TYPE_GET, paramsMap, new ReqCallBack<String>() {
            @Override
            public void onReqSuccess(String result) {
                AdsInfo adsInfo = JsonUtil.jsonToBean(result, AdsInfo.class);
                EventBus.getDefault().post(adsInfo);
            }

            @Override
            public void onReqFailed(String errorMsg) {

            }
        });
    }

    /**
     * 注意：
     * EventBus[3.0.0]
     * 1、此方法为接收请求返回的数据，并在UI线程更新UI的操作(不需要使用Handler即可完成)
     * 2、使用EventBus时，官方建议参数最好使用事件参数，
     *      即为每个事件定义特定参数，如果参数相同的两个注解函数会被同事调用
     * @param adsInfo
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void requestEventBus(AdsInfo adsInfo) {
        tvTip.setText(adsInfo.toString());
    }

}
