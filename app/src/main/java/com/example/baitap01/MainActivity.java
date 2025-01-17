package com.example.baitap01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_main);
        // Kích hoạt chế độ Edge-to-Edge
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Áp dụng WindowInsets để điều chỉnh padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liên kết các view trong giao diện
        CircleImageView imgStudent = findViewById(R.id.imgStudent);
        TextView tvStudentName = findViewById(R.id.tvStudentName);
        TextView tvStudentInfo = findViewById(R.id.tvStudentInfo);

        // Set dữ liệu cho giao diện
        imgStudent.setImageResource(R.drawable.avt); // Thêm ảnh mẫu vào drawable
        tvStudentName.setText("Nguyễn Vương Việt");
        tvStudentInfo.setText("MSSV: 22110457");
        // Khởi tạo ArrayList chứa các số
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // Tạo 2 ArrayList để chứa số lẻ và số chẵn
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        // Duyệt qua mảng và phân loại số lẻ và số chẵn
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        // In số chẵn ra Log
        Log.d("EvenNumbers", "Số chẵn: " + evenNumbers.toString());

        // In số lẻ ra Log
        Log.d("OddNumbers", "Số lẻ: " + oddNumbers.toString());
        // Liên kết các view trong giao diện
        EditText editTextInput = findViewById(R.id.editTextInput);
        Button buttonReverse = findViewById(R.id.buttonReverse);
        TextView textViewOutput = findViewById(R.id.textViewOutput);

        // Thiết lập sự kiện cho nút Button
        buttonReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy chuỗi nhập vào từ EditText
                String inputString = editTextInput.getText().toString();

                // Tách chuỗi thành các từ và đảo ngược thứ tự của các từ
                String[] words = inputString.split(" ");  // Tách chuỗi theo dấu cách
                StringBuilder reversedString = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    reversedString.append(words[i]).append(" ");  // Thêm từ vào StringBuilder
                }

                // Loại bỏ dấu cách thừa ở cuối chuỗi
                String resultString = reversedString.toString().trim();

                // Chuyển chuỗi đảo ngược thành chữ hoa
                String upperCaseString = resultString.toUpperCase();

                // Hiển thị kết quả lên TextView
                textViewOutput.setText(upperCaseString);

                // Hiển thị thông báo Toast
                Toast.makeText(MainActivity.this, upperCaseString, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
