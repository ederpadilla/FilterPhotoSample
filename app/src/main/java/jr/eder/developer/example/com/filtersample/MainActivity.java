package jr.eder.developer.example.com.filtersample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.co.cyberagent.android.gpuimage.GPUImage3x3ConvolutionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImage3x3TextureSamplingFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageAddBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageAlphaBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageBilateralFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHueFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageOpacityFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSepiaFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.gpuimage)
    GPUImageView img_pic;
    private File tempFile = new File("/sdcard/.a.jpg");
    private Bitmap originBitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
   @OnClick(R.id.select)
   public void select(){
       Intent intent = new Intent(Intent.ACTION_PICK);
       intent.setType("image/*");
       startActivityForResult(intent, 1);
   showLog("Select");
   }
   public void showLog(String log){
       Log.e("Debug ",log);
   }
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
       super.onActivityResult(requestCode, resultCode, data);
       if (resultCode == RESULT_OK) {
           Uri selectedImage = data.getData();
           InputStream imageStream;
           try {
               imageStream = getContentResolver().openInputStream(selectedImage);
               originBitmap = BitmapFactory.decodeStream(imageStream);
           } catch (FileNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           if (originBitmap != null) {
               tempFile.delete();
               img_pic.setImage(originBitmap);
           }
       }
   }
   @OnClick(R.id.btn_average_blur_style)
   public void averag(){
       img_pic.setFilter(new GPUImageSepiaFilter());
   }
   @OnClick(R.id.btn_GAUSSIAN_BLUR_STYLE)
   public void gaussian(){
       img_pic.setFilter(new GPUImage3x3ConvolutionFilter());
   }
   @OnClick(R.id.btn_SOFT_GLOW_STYLE)
   public void glow(){
       img_pic.setFilter(new GPUImage3x3TextureSamplingFilter());
   }
   @OnClick(R.id.btn_LIGHT_STYLE)
   public void light(){
       img_pic.setFilter(new GPUImageAddBlendFilter());
   }
   @OnClick(R.id.btn_LOMO_STYLE)
   public void lomo(){
       img_pic.setFilter(new GPUImageAlphaBlendFilter());
   }
   @OnClick(R.id.btn_NEON_STYLE)
   public void neon(){
       img_pic.setFilter(new GPUImageBilateralFilter());
   }
   @OnClick(R.id.btn_PIXELATE_STYLE)
   public void pixelate(){
       img_pic.setFilter(new GPUImageBrightnessFilter());
   }
   @OnClick(R.id.btn_MOTION_BLUR_STYLE)
   public void motionblur(){
       img_pic.setFilter(new GPUImageHueFilter());
   }
   @OnClick(R.id.btn_OIL_STYLE)
   public void oil(){
       img_pic.setFilter(new GPUImageOpacityFilter());
   }
}
