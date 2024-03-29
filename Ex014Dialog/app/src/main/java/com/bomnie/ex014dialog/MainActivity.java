package com.bomnie.ex014dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //멤버변수
    //다이얼로그의 항목으로 보여질 글씨들
    String[] items= new String[]{"Apple", "Banana", "Orange"};
    boolean[] checkedItems= new boolean[] {true, false, true};
    //체크박스와 같은 수의 배열: apple은 true, banana는 false, orange는 true


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickBtn(View view) {

        //AlertDialog 보이기

        //AlertDialog를 만들어주는 건축가(Builder)객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //건축가에게 원하는 작업요청
        builder.setTitle("다이얼로그");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        //builder.setMessage("Do you wanna Quit?");

        //메세지 영역의 다른 형태 사용해보기
        //1) List(항목)형태 메세지 영역 설정
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int which) {
//
//                //두번째 파라미터 which : 항목의 인덱스번호[가장 위 항목이 0번 ]
//                Toast t = Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT);
//                t.show();
//
//            }
//        });

        //2) 라디오버튼이 있는 항목형태의 설정
//        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int which) {
//
//                Toast t= Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT);
//                t.show();
//
//            }
//        });


//        //3) 체크박스 버튼이 있는 항목형태의 설정
//        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int which, boolean checked) { //String배열, boolean배열,  MultiChoiceClickListener
//                checkedItems[which] = checked;
//                //안 하면 원위치가 되므로 써줘야한다.
//            }
//        });

        //4) 커스텀 뷰로 메세지 영역 설정하기
//        builder.setView(R.layout.dialog); // API 21ver. 이상에서만 가능한 코드라서 아직은 사용X

        //layout 폴더 안에 있는 dialog.xml 문서를
        //Java의 View객체로 만들어 주는 (inflate: 부풀리다) 객체를 Context로부터 얻어오기
        //xml을 View로 만들어주는 친구
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog, null);

        //만들어진 뷰안에 있는 EditText, TextView 찾아오기
        //mainActivity가 아닌 et와 tv를 가지고 있는 inflater v 에게서 find
        et = v.findViewById(R.id.et);
        tv = v.findViewById(R.id.tv);

        builder.setView(v);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast 보이기
                Toast t= Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT);
                t.show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast보이기
                Toast t= Toast.makeText(MainActivity.this, "CANCEL", Toast.LENGTH_SHORT);
                t.show();
            }
        });

        //건축가(Builder)에게 AlertDialog 만들어 달라고 요청
        AlertDialog dialog= builder.create();

        //다이얼로그의 바깥쪽을 터치하였을 때 다이얼로그가 꺼지지 않도록..
        dialog.setCanceledOnTouchOutside(false);

        //뒤로가기 버튼을 클릭해도 꺼지지 않도록 하려면..
        dialog.setCancelable(false);

        //다이얼로그를 화면에 보이기!!
        dialog.show();
    }

    //메소드 밖 클래스 내부에 있으면 어디서든 멤버변수
    EditText et;
    TextView tv;

    public void clickDialogBtn(View v) {
        String s = et.getText().toString();
        tv.setText(s);

    }

}
















