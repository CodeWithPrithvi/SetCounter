package com.example.setcounter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView ctr;
    Button rst,inc,dec;
    public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ctr=findViewById(R.id.counter);
        rst=findViewById(R.id.reset);
        inc=findViewById(R.id.increment);
        dec=findViewById(R.id.decrement);
        rst.setOnClickListener(v -> {
            ctr.setText("0");
            count=0;
        });
        inc.setOnClickListener(v -> ctr.setText(increment()));
        dec.setOnClickListener(v -> {
            if (count>0) {
                ctr.setText(decrement());
            }
            else{
                Toast.makeText(getApplicationContext(),"Counter already at 0",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String increment()
    {
        count=count+1;
        return String.valueOf(count);
    }
    public String decrement()
    {
        count=count-1;
        return String.valueOf(count);
    }
}