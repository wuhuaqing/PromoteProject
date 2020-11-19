package com.example.promoteproject.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.promoteproject.MainActivity;
import com.example.promoteproject.R;
import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.LoginResp;
import com.example.promoteproject.bean.Repository;
import com.example.promoteproject.net.NetMoudle;
import com.example.promoteproject.net.RxNetLoginMoudle;
import com.example.promoteproject.net.RxNetMoudle;
import com.example.promoteproject.ui.notify.NotifyTestActivity;
import com.example.promoteproject.util.DebouncingOnClickListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private TextView textView;
    private RxNetLoginMoudle loginMoudle;
    private NetMoudle netMoudle;
    private RxNetMoudle rxNetMoudle;
    private String tag = LoginActivity.class.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = findViewById(R.id.btn_login);

        Button btnRxjava = findViewById(R.id.btn_rxjava);
        textView = findViewById(R.id.tv_resp);
        netMoudle = new NetMoudle();
        netMoudle.buildRetrofit();

        rxNetMoudle = new RxNetMoudle();
        rxNetMoudle.buildRetrofit();

        loginMoudle = new RxNetLoginMoudle();
        loginMoudle.buildRetrofit();
        Button btn_get = findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netMoudle.getContributors();
                retrofitContributors();
                Log.e(tag, "方法调用后的字符打印");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlogin();
            }
        });
        btnRxjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //testRxjava();
                testRxjavaBase();
            }
        });


    }

    private void userlogin() {
        Observable<LoginResp> loginRespObservable = loginMoudle.userLogin();
        loginRespObservable.subscribe(loginResp -> {
            textView.setText(loginResp.toString());
        }, throwable -> {
            Log.e("LoginActivity", throwable.getMessage());
        });

        loginRespObservable.subscribe(new Consumer<LoginResp>() {
            @Override
            public void accept(LoginResp loginResp) throws Exception {

            }

        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

        // Observable<LoginResp> loginRespObservable = loginMoudle.userLogin();
        loginRespObservable
                .subscribeOn(Schedulers.io())//可观察操作设置在io线程
                .observeOn(AndroidSchedulers.mainThread())//观察者处理数据所在的线程
                .map(new Function<LoginResp, String>() {
                    @Override
                    public String apply(LoginResp loginResp) throws Exception {
                        return loginResp == null ? "" : loginResp.name;
                    }
                })
                .observeOn(Schedulers.newThread())//观察者处理数据所在的线程
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {

                        return s.equals("whq") ? 1 : 0;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer s) {
                        textView.setText(s + "");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void testRxjava() {


        Single.just(1) //生成一个可观察对象
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "map integer to String: " + integer;
                    }
                }) //生成对可观察对象进行转换的可观察对象
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        textView.setText("" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }); //将可观察对象订阅给观察者对象

        Observable.just(1, 2)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void testRxjavaBase() {

        StringBuffer content = new StringBuffer("");
        Observable<Object> objectObservable = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext("3");
                emitter.onNext("4");
                emitter.onComplete();
            }
        });

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                content.append("onSubscribe;");
            }

            @Override
            public void onNext(Object o) {
                content.append((String) o);
            }

            @Override
            public void onError(Throwable e) {
                content.append("onError");
            }

            @Override
            public void onComplete() {
                content.append("onComplete!");
                textView.setText(content.toString());
            }
        };

        objectObservable.subscribe(observer);
    }


    /**
     * 仓库信息
     */
    private void retrofitResp() {
        Observable<Repository> respository = rxNetMoudle.getRespository();
        respository.subscribe(repository -> {
            textView.setText(repository.toString());
        }, throwable -> {
            Log.e(this.getClass().getName(), throwable.getMessage());
            textView.setText(throwable.getMessage());
        });
        /*respository.subscribe(new Consumer<Repository>() {
            @Override
            public void accept(Repository repository) throws Exception {
                textView.setText(repository.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(MainActivity.this.getClass().getName(),throwable.getMessage());
                textView.setText(throwable.getMessage());
            }
        });*/
    }

    /**
     * 贡献人信息
     */
    private void retrofitContributors() {
        Observable<List<Contributor>> contributors = rxNetMoudle.getContributors();
        contributors.subscribe(contributors1 -> {
            StringBuilder str = new StringBuilder("");
            for (Contributor contributor : contributors1) {
                str.append(contributor.toString());
            }
            textView.setText(str.toString());
        }, throwable -> {
            Log.e(this.getClass().getName(), throwable.getMessage());
            textView.setText(throwable.getMessage());
        });


    }


}