package com.giousa.bmobgiou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.giousa.bmobgiou.bean.Student;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.btn_create)
    Button mBtnCreate;
    @InjectView(R.id.btn_query)
    Button mBtnQuery;
    @InjectView(R.id.btn_update)
    Button mBtnUpdate;
    @InjectView(R.id.btn_delete)
    Button mBtnDelete;
    private String mObjectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "e4ddd1b687b74bccf91fa43ab8eaef63");

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_create, R.id.btn_query, R.id.btn_update, R.id.btn_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_create:
                createData();
                break;
            case R.id.btn_query:
                queryData();
                break;
            case R.id.btn_update:
                updateData();
                break;
            case R.id.btn_delete:
                deleteData();
                break;
        }
    }

    private int count = 0;

    /**
     * 添加数据
     */
    private void createData() {
        Student student = new Student();
        student.setName("灵梦"+count);
        student.setAge(16+count);
        student.setHobby("赛钱箱"+count);
        student.setHeight(156f+count);
        student.setPhoneNum("119"+count);
        student.setEmail("777"+count);
        student.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Log.d(TAG,"添加数据成功，返回objectId为："+s);
                    mObjectId = s;
                }else{
                    Log.d(TAG,"创建数据失败：" + e.getMessage());
                }
            }
        });
        count++;
    }

    /**
     * 查找数据
     */
    private void queryData() {
        BmobQuery<Student> query = new BmobQuery<>();
        query.addWhereEqualTo("name", "灵梦1");
        query.findObjects(new FindListener<Student>() {
            @Override
            public void done(List<Student> object, BmobException e) {
                if(e==null){
                    Log.d(TAG,"查询成功：共"+object.size()+"条数据。");
                    for (Student student : object) {
                        Log.d(TAG,student.toString());
                    }
                }else{
                    Log.d(TAG,"失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

    /**
     *
     * 更新数据
     *
     *
     * 备注：目前更新数据，只能使用objectId，还不能通过判断条件来更新。
     *      不过，在添加数据的时候，因为会返回一个objectId，可以先通过查询
     *      获取到对应数据的objectId后，再执行更新和删除
     */
    private void updateData() {

        Student student = new Student();
        student.setValue("name","魔理沙");
        student.setValue("age",15);
        student.update(mObjectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.d(TAG,"更新成功");
                }else{
                    Log.d(TAG,"更新失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });

    }

    /**
     * 删除数据
     */
    private void deleteData() {
        Student p2 = new Student();
        p2.setObjectId(mObjectId);
        p2.delete(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.d(TAG,"删除成功:");

                }else{
                    Log.d(TAG,"删除失败：" + e.getMessage());
                }
            }

        });
    }
}
