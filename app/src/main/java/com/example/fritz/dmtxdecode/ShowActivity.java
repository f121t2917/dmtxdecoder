package com.example.fritz.dmtxdecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.libdmtx.DMTXImage;
import org.libdmtx.DMTXTag;

import java.nio.IntBuffer;

public class ShowActivity extends AppCompatActivity  implements View.OnClickListener {

    public static final int SEARCH_TIMEOUT = 50000;
    private ImageView imageView;
    private TextView textView;
    DMTXTag[]tags;
    static {//加载so库
        //System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView2);
        findViewById(R.id.show).setOnClickListener(this);
        findViewById(R.id.process).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test66);

            int size = bitmap.getHeight() * bitmap.getWidth();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            IntBuffer buff = IntBuffer.allocate(size);
            bitmap.copyPixelsToBuffer(buff);

            DMTXImage dmtx = new DMTXImage(bitmap.getWidth(), bitmap.getHeight(), buff.array());

            tags = dmtx.getTags(60, SEARCH_TIMEOUT);

            if (tags != null) {
                int i = 0;
                for (DMTXTag tag : tags) {
                    System.out.println("Tag Found! Coord" + i + ": " + tag.corner1.getX() + "," +
                            tag.corner1.getY() + " Tag value: " + tag.id);
                    i++;
                }
                //System.out.println("Decoding time: " + decodingTime);
            }
            else {
                System.out.println("No tag found");
            }

            // 將圖檔等比例縮小至寬度為1024
            final int MAX_WIDTH = 1024;
            final int MAX_HEIGHT = 2048;
            float resize = 1; // 縮小值 resize 可為任意小數
            if(width > MAX_WIDTH){
                resize = ((float) MAX_WIDTH) / width;
            }

            // 產生縮圖需要的參數 matrix
            Matrix matrix = new Matrix();
            matrix.postScale(resize, resize); // 設定寬高的縮放比例

            // 產生縮小後的圖
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

            imageView.setImageBitmap(resizedBitmap);
        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test6);
            //getEdge(bitmap);
            imageView.setImageBitmap(bitmap);
        }

        textView.setText("批號: H1EAOZ017E 數量: 60");
    }

    //native void getEdge(Object bitmap);
}
