package jr.eder.developer.example.com.filtersample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.co.cyberagent.android.gpuimage.GPUImage3x3ConvolutionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImage3x3TextureSamplingFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageAddBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageAlphaBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageBoxBlurFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageBulgeDistortionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageCGAColorspaceFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageChromaKeyBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorBalanceFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorBurnBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorDodgeBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorInvertFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageColorMatrixFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageContrastFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageCrosshatchFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageDifferenceBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageDirectionalSobelEdgeDetectionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageDissolveBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageDivideBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageEmbossFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageExclusionBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageExposureFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageFalseColorFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageGammaFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageGaussianBlurFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageGlassSphereFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageGrayscaleFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHalftoneFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHardLightBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHazeFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHighlightShadowFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHueBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageHueFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageKuwaharaFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLaplacianFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLevelsFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLightenBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLinearBurnBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLookupFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageLuminosityBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageMonochromeFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageMultiplyBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageNonMaximumSuppressionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageNormalBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageOpacityFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageOverlayBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImagePixelationFilter;
import jp.co.cyberagent.android.gpuimage.GPUImagePosterizeFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageRGBDilationFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageRGBFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSaturationBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSaturationFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageScreenBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSepiaFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSharpenFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSketchFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSmoothToonFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSobelThresholdFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSoftLightBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSourceOverBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSphereRefractionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSubtractBlendFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageSwirlFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageToneCurveFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageToonFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageTransformFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageView;
import jp.co.cyberagent.android.gpuimage.GPUImageVignetteFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageWeakPixelInclusionFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageWhiteBalanceFilter;

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.recView)
    RecyclerView recyclerView;
    @BindView(R.id.gpuimage)
    GPUImageView gpuImageView;
    List<Filtro> filtros;
    FiltrosAdapter filtrosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);
        recViewInit();
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.foto);
        gpuImageView.setImage(largeIcon);
    }

    private void recViewInit() {
        filtros= new ArrayList<Filtro>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        filtrosAdapter= new FiltrosAdapter(filtros,this);
        recyclerView.setAdapter(filtrosAdapter);
        filters();
        filtrosAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filtro filtro = filtros.get(recyclerView.getChildPosition(v));
                chooseFilter(filtro.getId());
            }
        });
    }
    private void filters(){
        for (int i =0;i<=70;i++){
            Filtro filtroi = new Filtro("Filtro "+i,i);
            filtros.add(filtroi);
        }
     filtrosAdapter.notifyDataSetChanged();
    }


    public void showLog(String log){
        Log.e("Debug ",log);
    }
    public void chooseFilter(int select){
        switch (select){
            case 0:
                showLog("3 x 3 convolution");
                gpuImageView.setFilter(new GPUImage3x3ConvolutionFilter());
                break;
            case 1:
                showLog("3 x 3 texture");
                gpuImageView.setFilter(new GPUImage3x3TextureSamplingFilter());
                break;
            case 2:
                showLog("Add blend");
                gpuImageView.setFilter(new GPUImageAddBlendFilter());
                break;
            case 3:
                showLog("Alpha blend");
                gpuImageView.setFilter(new GPUImageAlphaBlendFilter(.3f));/////////obscurece la foto
                break;
            case 4:
                showLog("Box Blur filter");
                gpuImageView.setFilter(new GPUImageBoxBlurFilter(1.1f));///////////desenfoca
                break;
            case 5:
                showLog("Brightness filter");
                gpuImageView.setFilter(new GPUImageBrightnessFilter(.3f));///////agrega brillo
                break;
            case 6:
                showLog("Distortion filter");
                gpuImageView.setFilter(new GPUImageBulgeDistortionFilter());
                break;
            case 7:
                showLog("Color space filter");
                gpuImageView.setFilter(new GPUImageCGAColorspaceFilter());
                break;
            case 8:
                showLog("Chroma key blend");
                gpuImageView.setFilter(new GPUImageChromaKeyBlendFilter());
                showToast();
                ////////no hace nada
                break;
            case 9:
                showLog("Color balance filter");
                gpuImageView.setFilter(new GPUImageColorBalanceFilter());
                showToast();
                //No hace nada
                break;
            case 10:
                showLog("Color blend filter");
                gpuImageView.setFilter(new GPUImageColorBlendFilter());
                break;
            case 11:
                showLog("Color burn");
                gpuImageView.setFilter(new GPUImageColorBurnBlendFilter());
                break;
            case 12:
                showLog("Color dodge blend");
                gpuImageView.setFilter(new GPUImageColorDodgeBlendFilter());
                showToast();
                //No hace nada
                break;
            case 13:
                showLog("Color invert");
                gpuImageView.setFilter(new GPUImageColorInvertFilter());
                break;
            case 14:
                showLog("Color matrix");
                gpuImageView.setFilter(new GPUImageColorMatrixFilter());//sin manejar
                break;
            case 15:
                showLog("Constrast filter");
                gpuImageView.setFilter(new GPUImageContrastFilter(.4f));//enpolvece
                break;
            case 16:
                showLog("Crosshatch");
                gpuImageView.setFilter(new GPUImageCrosshatchFilter(.01f,.004f));//pencil cartoon
                break;
            case 17:
                showLog("Difference blend");
                gpuImageView.setFilter(new GPUImageDifferenceBlendFilter());
                showToast();
                //no hace nada
                break;
            case 18:
                showLog("Directional sobel edge");
                gpuImageView.setFilter(new GPUImageDirectionalSobelEdgeDetectionFilter());
                //creepy shit
                break;
            case 19:
                showLog("Dissolve blend");
                gpuImageView.setFilter(new GPUImageDissolveBlendFilter(.2f));//obscurese la foto
                break;
            case 20:
                showLog("Divide blend");
                gpuImageView.setFilter(new GPUImageDivideBlendFilter());///creepy white shit
                break;
            case 21:
                showLog("Emboss");
                gpuImageView.setFilter(new GPUImageEmbossFilter(1.2f));//toon shit
                break;
            case 22:
                showLog("Exclusion blend");
                gpuImageView.setFilter(new GPUImageExclusionBlendFilter());
                showToast();
                //no hace nada
                break;
            case 23:
                showLog("Exposure filter");
                gpuImageView.setFilter(new GPUImageExposureFilter(.5f));//////////nos hace amarillos
                break;
            case 24:
                showLog("False color filter");
                gpuImageView.setFilter(new GPUImageFalseColorFilter());
                //red shit
                break;
            case 25:
                showLog("Gamma filter");
                gpuImageView.setFilter(new GPUImageGammaFilter(1.8f));/// oscurese bonito
                break;
            case 26:
                showLog("GaussianBlur");
                gpuImageView.setFilter(new GPUImageGaussianBlurFilter(1.5f));////////desenfoca
                break;
            case 27:
                showLog("GlassSpherer");
                gpuImageView.setFilter(new GPUImageGlassSphereFilter(new PointF(0.5f, 0.5f), 0.5f, 0.6f));
                //Hace una esfera
                break;
            case 28:
                showLog("GrayScale");
                gpuImageView.setFilter(new GPUImageGrayscaleFilter());
                break;
            case 29:
                showLog("Haltone filter");
                gpuImageView.setFilter(new GPUImageHalftoneFilter(.001f));//shit rara
                break;
            case 30:
                showLog("Hardlight");
                gpuImageView.setFilter(new GPUImageHardLightBlendFilter());
                showToast();
                //no hace nada
                break;
            case 31:
                showLog("Haze filter");
                gpuImageView.setFilter(new GPUImageHazeFilter(.01f,0.5f));//Contraste
                break;
            case 32:
                showLog("Highlight shadow");
                gpuImageView.setFilter(new GPUImageHighlightShadowFilter(.8f,.8f));//Pastel
                break;
            case 33:
                showLog("HueBlend");
                gpuImageView.setFilter(new GPUImageHueBlendFilter());//Black and white
                break;
            case 34:
                showLog("Exposure filter");
                gpuImageView.setFilter(new GPUImageHueFilter(20f));//enverdece
                break;
            case 35:
                showLog("Kuawahara");
                gpuImageView.setFilter(new GPUImageKuwaharaFilter());//arte abstracta
                break;
            case 36:
                showLog("Lapacian");
                gpuImageView.setFilter(new GPUImageLaplacianFilter());//gris todo
                break;
            case 37:
                showLog("Levels");
                gpuImageView.setFilter(new GPUImageLevelsFilter());
                showToast();
                //no hace nada
                break;
            case 38:
                showLog("Light Blend");
                gpuImageView.setFilter(new GPUImageLightenBlendFilter());
                showToast();
                //no hace nada
                break;
            case 39:
                showLog("Linear burn");
                gpuImageView.setFilter(new GPUImageLinearBurnBlendFilter());
                showToast();
                //no hace nada
                break;
            case 40:
                showLog("Look up");
                gpuImageView.setFilter(new GPUImageLookupFilter(.2f));//obscurese
                break;
            case 41:
                showLog("Luminostyy");
                gpuImageView.setFilter(new GPUImageLuminosityBlendFilter());
                showToast();
                //no hace nada
                break;
            case 42:
                showLog("Monochrome");
                gpuImageView.setFilter(new GPUImageMonochromeFilter(1.8f, new float[] {0.2f, 0.5f, 0.2f, 1.0f}));
                //old foto
                break;
            case 43:
                showLog("Multiply blend");
                gpuImageView.setFilter(new GPUImageMultiplyBlendFilter());
                showToast();
                //no sirve
                break;
            case 44:
                showLog("Non maximum");
                gpuImageView.setFilter(new GPUImageNonMaximumSuppressionFilter());
                //feo
                break;
            case 45:
                showLog("Normal blend");
                gpuImageView.setFilter(new GPUImageNormalBlendFilter());
                showToast();
                //no hace nada
                break;
            case 46:
                showLog("Opacity");
                gpuImageView.setFilter(new GPUImageOpacityFilter(.001f));///No hace nada
                break;
            case 47:
                showLog("Overlay");
                //obscurese
                break;
            case 48:
                showLog("Pixelation");
                gpuImageView.setFilter(new GPUImagePixelationFilter());
                showToast();
                //no hace nada
                break;
            case 49:
                showLog("Posterize");
                gpuImageView.setFilter(new GPUImagePosterizeFilter(8));//arte
                break;
            case 50:
                showLog("RGBDilatation");
                gpuImageView.setFilter(new GPUImageRGBDilationFilter(2));//fun
                break;
            case 51:
                showLog("RGB");
                gpuImageView.setFilter(new GPUImageRGBFilter(1.f,2f,3f));//RGB
                break;
            case 52:
                showLog("Saturation blend");
                gpuImageView.setFilter(new GPUImageSaturationBlendFilter());//blanco y negro y verde
                break;
            case 53:
                showLog("Saturation");
                gpuImageView.setFilter(new GPUImageSaturationFilter(1.5f));//saturacion
                break;
            case 54:
                showLog("Screen blend");
                gpuImageView.setFilter(new GPUImageScreenBlendFilter());
                showToast();
                //no hace nada
                break;
            case 55:
                showLog("Sepia");
                gpuImageView.setFilter(new GPUImageSepiaFilter(.5f));///sephia
                break;
            case 56:
                showLog("Sharpen");
                gpuImageView.setFilter(new GPUImageSharpenFilter(10f));//bordos blancos
                break;
            case 57:
                showLog("Sketch");
                gpuImageView.setFilter(new GPUImageSketchFilter());//blanco blanco
                break;
            case 58:
                showLog("Smothfilter");
                gpuImageView.setFilter(new GPUImageSmoothToonFilter());//turbo arte
                break;
            case 59:
                showLog("SobelTheshold");
                gpuImageView.setFilter(new GPUImageSobelThresholdFilter(.8f));//Draw my life
                break;
            case 60:
                showLog("SoftLight");
                gpuImageView.setFilter(new GPUImageSoftLightBlendFilter());//baja la luz
                break;
            case 61:
                showLog("Sourceoverblend");
                gpuImageView.setFilter(new GPUImageSourceOverBlendFilter());
                //no sirve
                showToast();
                break;
            case 62:
                showLog("Spehererefraction");
                gpuImageView.setFilter(new GPUImageSphereRefractionFilter(new PointF(0.5f, 0.5f), 0.5f, 0.5f));//espera
                break;
            case 63:
                showLog("Substractblend");
                gpuImageView.setFilter(new GPUImageSubtractBlendFilter());
                //no hace nada
                showToast();
                break;
            case 64:
                showLog("SwirlFilter");
                gpuImageView.setFilter(new GPUImageSwirlFilter(.2f,.4f,new PointF(.5f,.5f)));//funny distortion
                break;
            case 65:
                showLog("Tone curve");
                gpuImageView.setFilter(new GPUImageToneCurveFilter());
                //no sirve
                showToast();
                break;
            case 66:
                showLog("Toon filter");
                gpuImageView.setFilter(new GPUImageToonFilter(0.4f, 9.0f));///Toon
                break;
            case 67:
                showLog("TransformFilter");
                gpuImageView.setFilter(new GPUImageTransformFilter());
                //no hace nada
                showToast();
                break;
            case 68:
                showLog("Vignete");
                gpuImageView.setFilter(new GPUImageVignetteFilter(new PointF(), new float[] {0.0f, 0.0f, 0.0f}, .4f, 1.5f));//viñeta
                break;
            case 69:
                showLog("Weak pixel");
                gpuImageView.setFilter(new GPUImageWeakPixelInclusionFilter());
                //raro
                break;
            case 70:
                showLog("White balance");
                gpuImageView.setFilter(new GPUImageWhiteBalanceFilter(200f,3f));///balance
                break;

        }
    }
    public void showToast(){
        CharSequence text = "No sirve";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

}
