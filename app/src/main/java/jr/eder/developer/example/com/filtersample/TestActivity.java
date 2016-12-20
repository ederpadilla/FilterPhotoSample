package jr.eder.developer.example.com.filtersample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.picassotransformations.Kernel;
import com.picassotransformations.jhlabs.ArrayColormap;
import com.picassotransformations.jhlabs.BlockTransformation;
import com.picassotransformations.jhlabs.BlurTransformation;
import com.picassotransformations.jhlabs.ChannelMixTransformation;
import com.picassotransformations.jhlabs.ContrastTransformation;
import com.picassotransformations.jhlabs.ConvolveTransformation;
import com.picassotransformations.jhlabs.CurvesTransformation;
import com.picassotransformations.jhlabs.DiffusionTransformation;
import com.picassotransformations.jhlabs.DitherTransformation;
import com.picassotransformations.jhlabs.EdgeTransformation;
import com.picassotransformations.jhlabs.EmbossTransformation;
import com.picassotransformations.jhlabs.EqualizeTransformation;
import com.picassotransformations.jhlabs.ExposureTransformation;
import com.picassotransformations.jhlabs.GainTransformation;
import com.picassotransformations.jhlabs.GrayTransformation;
import com.picassotransformations.jhlabs.GrayscaleTransformation;
import com.picassotransformations.jhlabs.HSBAdjustTransformation;
import com.picassotransformations.jhlabs.InvertAlphaTransformation;
import com.picassotransformations.jhlabs.InvertTransformation;
import com.picassotransformations.jhlabs.KaleidoscopeTransformation;
import com.picassotransformations.jhlabs.LevelsTransformation;
import com.picassotransformations.jhlabs.LookupTransformation;
import com.picassotransformations.jhlabs.MapColorsTransformation;
import com.picassotransformations.jhlabs.MarbleTransformation;
import com.picassotransformations.jhlabs.MaskTransformation;
import com.picassotransformations.jhlabs.MirrorTransformation;
import com.picassotransformations.jhlabs.PointTransformation;
import com.picassotransformations.jhlabs.PolarTransformation;
import com.picassotransformations.jhlabs.PosterizeTransformation;
import com.picassotransformations.jhlabs.QuantizeTransformation;
import com.picassotransformations.jhlabs.RGBAdjustTransformation;
import com.picassotransformations.jhlabs.RescaleTransformation;
import com.picassotransformations.jhlabs.SolarizeTransformation;
import com.picassotransformations.jhlabs.ThresholdTransformation;
import com.picassotransformations.jhlabs.TransferTransformation;
import com.picassotransformations.jhlabs.TransformTransformation;
import com.picassotransformations.jhlabs.TritoneTransformation;
import com.picassotransformations.jhlabs.WholeImageTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

   //@BindView(R.id.gpuimage)
   //GPUImageView gpuImageView;


    private List<Filtro> filtros;

    private FiltrosAdapter filtrosAdapter;

    @BindView(R.id.img)
    ImageView imageView;

    private Uri myUri;

    private TransformationCategory mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);
        recViewInit();
        //Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.foto);
        //gpuImageView.setImage(largeIcon);
        myUri = Uri.parse("http://www.pueblaonline.com.mx/2015/portal//media/k2/galleries_p/32715/thumb_front/js2.jpg");

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
        for (int i =0;i<=28;i++){
            Filtro filtroi = new Filtro("Filtro "+i,i);
            filtros.add(filtroi);
        }
     filtrosAdapter.notifyDataSetChanged();
    }
    public void chooseFilter(int select){
        switch (select){
            case 0:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new BlockTransformation(4))
                        .into(imageView);
                showLog("Block transformation");
                break;
            case 1:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new jr.eder.developer.example.com.filtersample.BlurTransformation(getApplicationContext()))
                        .into(imageView);
                showLog("Blur");
                break;
            case 2:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new ChannelMixTransformation())
                        .into(imageView);
                showLog("ChannelMix");
                break;
            case 3:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new ContrastTransformation())
                        .into(imageView);
                showLog("contrast");
                break;
            //case 4:
            //    float[] matrix = new float[9];
            //    Picasso.with(getApplicationContext()).load(myUri)
            //            .transform(new ConvolveTransformation(new Kernel(3, 3, matrix)))/////////no se maneja
            //            .into(imageView);
            //    showLog("Convolve");
            //    break;
            //case 5:
            //    Picasso.with(getApplicationContext()).load(myUri)
            //            .transform(new CurvesTransformation())
            //            .into(imageView);
            //    showLog("Curves");////no sirve
            //    break;
            case 4:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new DiffusionTransformation())
                        .into(imageView);
                showLog("Diffusion");
                break;
            case 5:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new DitherTransformation())
                        .into(imageView);
                showLog("Dither");
                break;
            case 6:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new EdgeTransformation())
                        .into(imageView);
                showLog("Edge");
                break;
            case 7:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new EmbossTransformation())
                        .into(imageView);
                showLog("Emboss");
                break;
            case 8:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new EqualizeTransformation())
                        .into(imageView);
                showLog("Equalizer");
                break;
            case 9:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new ExposureTransformation())
                        .into(imageView);
                showLog("Exposure");
                break;
            case 10:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new GainTransformation())
                        .into(imageView);
                showLog("Gain Transform");
                break;
            case 11:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new GrayTransformation())
                        .into(imageView);
                showLog("Gray Tranform");
                break;
            case 12:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new GrayscaleTransformation())
                        .into(imageView);
                showLog("Grayscale");
                //red shit
                break;
            case 13:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new HSBAdjustTransformation(.1f,.1f,.1f))///////////
                        .into(imageView);
                showLog("HSBA");
                break;
            case 14:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new InvertAlphaTransformation())
                        .into(imageView);
                showLog("Invert");
                break;
            case 15:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new InvertTransformation())
                        .into(imageView);
                showLog("InvertTransofrm");
                break;
            case 16:
                float angle = .01F;
                float angle2 = .01F;
                float centreX = .05F;
                float centreY = .05F;
                int sides = 3;
                KaleidoscopeTransformation kaleidoscopeTransformation = new KaleidoscopeTransformation();
                kaleidoscopeTransformation.setEdgeAction(5);
                kaleidoscopeTransformation.setAngle(angle);
                kaleidoscopeTransformation.setAngle2(angle2);
                kaleidoscopeTransformation.setCentreX(centreX);
                kaleidoscopeTransformation.setCentreY(centreY);
                kaleidoscopeTransformation.setSides(sides);
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(kaleidoscopeTransformation)
                        .into(imageView);
                showLog("Kaleido");
                break;
            case 17:
                float lowLevel = 1.6F;
                float highLevel = 3.5F;
                float lowOutputLevel = 1.6F;
                float highOutputLevel = 3.1F;
                LevelsTransformation levelsTransformation = new LevelsTransformation();
                levelsTransformation.setLowLevel(lowLevel);
                levelsTransformation.setHighLevel(highLevel);
                levelsTransformation.setLowOutputLevel(lowOutputLevel);
                levelsTransformation.setHighOutputLevel(highOutputLevel);
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(levelsTransformation)
                        .into(imageView);
                showLog("Levels");
                break;
            case 18:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new LookupTransformation())/////////
                        .into(imageView);
                showLog("LookUp");
                break;
           //case 21:
           //    Picasso.with(getApplicationContext()).load(myUri)
           //            .transform(new MapColorsTransformation(-120,-50))////////////no sirve
           //            .into(imageView);
           //    showLog("MApcolor");
           //    break;
            case 19:
                float xScale = 1.5F;
                float yScale = 1.5F;
                float amount = 3.0F;
                float turbulence = 2.5F;
                MarbleTransformation marbleTransformation = new MarbleTransformation();
                marbleTransformation.setXScale(xScale);
                marbleTransformation.setYScale(yScale);
                marbleTransformation.setAmount(amount);
                marbleTransformation.setTurbulence(turbulence);

                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(marbleTransformation)
                        .into(imageView);
                showLog("Marble");
                break;
            case 20:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new MaskTransformation(143456789))////////////
                        .into(imageView);
                showLog("Mask");
                break;
            case 21:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new MirrorTransformation())
                        .into(imageView);
                showLog("Mirror");
                break;
            //case 22:
            //    Picasso.with(getApplicationContext()).load(myUri)
            //            .transform(new PointTransformation() {
            //                @Override
            //                public int filterRGB(int i, int i1, int i2) {
            //                    return 0;
            //                }
//
            //                @Override
            //                public String key() {
            //                    return null;
            //                }
            //            })
            //            .into(imageView);
            //    break;////// ni idea
            //case 26:
            //    Picasso.with(getApplicationContext()).load(myUri)
            //            .transform(new PolarTransformation(1))//////////// no esta cool
            //            .into(imageView);
            //    showLog("Polar");
            //    break;

            case 22:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new PosterizeTransformation())
                        .into(imageView);
                showLog("Posterize");
                break;

            case 23:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new QuantizeTransformation())
                        .into(imageView);
                showLog("Quantize");
                break;

            case 24:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new RGBAdjustTransformation(1f,1f,1f))///////////
                        .into(imageView);
                showLog("RGBA");
                break;
            case 25:
                showLog("Overlay");
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new RescaleTransformation(2.1f))////////
                        .into(imageView);
                showLog("Rescale");
                break;

            case 26:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new SolarizeTransformation())
                        .into(imageView);
                showLog("Solarize");
                break;
            case 27:
                Picasso.with(getApplicationContext()).load(myUri)
                        .transform(new ThresholdTransformation(95))//////////
                        .into(imageView);
                showLog("Threshold");
                break;
          //  case 28:
          //      Picasso.with(getApplicationContext()).load(myUri)
          //              .transform(new TransferTransformation() {
          //                  @Override
          //                  public String key() {
          //                      return null;
          //                  }
          //              })
          //              .into(imageView);
          //      break;
          //  case 29:
          //      Picasso.with(getApplicationContext()).load(myUri)
          //              .transform(new TransformTransformation() {
          //                  @Override
          //                  protected void transformInverse(int i, int i1, float[] floats) {
//
          //                  }
//
          //                  @Override
          //                  public String key() {
          //                      return null;
          //                  }
          //              })
          //              .into(imageView);
          //      break;
          //case 28:
          //   int shadowColor = -167;
          //   int midColor = -78;
          //   int highColor = -1;
          //    TritoneTransformation tritoneTransformation = new TritoneTransformation();
          //    tritoneTransformation.setShadowColor(shadowColor);
          //    tritoneTransformation.setMidColor(midColor);
          //    tritoneTransformation.setHighColor(highColor);
          //    Picasso.with(getApplicationContext()).load(myUri)
          //            .transform(tritoneTransformation)
          //            .into(imageView);
          //    showLog("Tritone");///// no idea
          //    break;

            //case 36:
            //    Picasso.with(getApplicationContext()).load(myUri)
            //            .transform(new WholeImageTransformation() {
            //                @Override
            //                protected int[] filterPixels(int i, int i1, int[] ints, Rect rect) {
            //                    return new int[0];
            //                }
//
            //                @Override
            //                public String key() {
            //                    return null;
            //                }
            //            })
            //            .into(imageView);
            //    break;

        }
    }

  // public void chooseFilter(int select){
  //     switch (select){
  //         case 0:
  //             showLog("Box Blur filter");
  //             gpuImageView.setFilter(new GPUImageBoxBlurFilter(1.1f));///////////desenfoca
  //             break;
  //         case 1:
  //             showLog("Brightness filter");
  //             gpuImageView.setFilter(new GPUImageBrightnessFilter(.3f));///////agrega brillo
  //             break;
  //         case 2:
  //             showLog("Distortion filter");
  //             gpuImageView.setFilter(new GPUImageBulgeDistortionFilter());
  //             break;
  //         case 3:
  //             showLog("Color space filter");
  //             gpuImageView.setFilter(new GPUImageCGAColorspaceFilter());
  //             break;
  //         case 4:
  //             showLog("Color blend filter");
  //             gpuImageView.setFilter(new GPUImageColorBlendFilter());
  //             break;
  //         case 5:
  //             showLog("Color burn");
  //             gpuImageView.setFilter(new GPUImageColorBurnBlendFilter());
  //             break;
  //         case 6:
  //             showLog("Color invert");
  //             gpuImageView.setFilter(new GPUImageColorInvertFilter());
  //             break;
  //         case 7:
  //             showLog("Constrast filter");
  //             gpuImageView.setFilter(new GPUImageContrastFilter(.4f));//enpolvece
  //             break;
  //         case 8:
  //             showLog("Crosshatch");
  //             gpuImageView.setFilter(new GPUImageCrosshatchFilter(.01f,.004f));//pencil cartoon
  //             break;
  //         case 9:
  //             showLog("Directional sobel edge");
  //             gpuImageView.setFilter(new GPUImageDirectionalSobelEdgeDetectionFilter());
  //             //creepy shit
  //             break;
  //         case 10:
  //             showLog("Dissolve blend");
  //             gpuImageView.setFilter(new GPUImageDissolveBlendFilter(.2f));//obscurese la foto
  //             break;
  //         case 11:
  //             showLog("Divide blend");
  //             gpuImageView.setFilter(new GPUImageDivideBlendFilter());///creepy white shit
  //             break;
  //         case 12:
  //             showLog("Emboss");
  //             gpuImageView.setFilter(new GPUImageEmbossFilter(1.2f));//toon shit
  //             break;
  //         case 13:
  //             showLog("Exposure filter");
  //             gpuImageView.setFilter(new GPUImageExposureFilter(.5f));//////////nos hace amarillos
  //             break;
  //         case 14:
  //             showLog("False color filter");
  //             gpuImageView.setFilter(new GPUImageFalseColorFilter());
  //             //red shit
  //             break;
  //         case 15:
  //             showLog("Gamma filter");
  //             gpuImageView.setFilter(new GPUImageGammaFilter(1.8f));/// oscurese bonito
  //             break;
  //         case 16:
  //             showLog("GaussianBlur");
  //             gpuImageView.setFilter(new GPUImageGaussianBlurFilter(1.5f));////////desenfoca
  //             break;
  //         case 17:
  //             showLog("GlassSpherer");
  //             gpuImageView.setFilter(new GPUImageGlassSphereFilter(new PointF(0.5f, 0.5f), 0.5f, 0.6f));
  //             //Hace una esfera
  //             break;
  //         case 18:
  //             showLog("GrayScale");
  //             gpuImageView.setFilter(new GPUImageGrayscaleFilter());
  //             break;
  //         case 19:
  //             showLog("Haltone filter");
  //             gpuImageView.setFilter(new GPUImageHalftoneFilter(.001f));//shit rara
  //             break;
  //         case 20:
  //             showLog("Haze filter");
  //             gpuImageView.setFilter(new GPUImageHazeFilter(.01f,0.5f));//Contraste
  //             break;
  //         case 21:
  //             showLog("Highlight shadow");
  //             gpuImageView.setFilter(new GPUImageHighlightShadowFilter(.8f,.8f));//Pastel
  //             break;
  //         case 22:
  //             showLog("HueBlend");
  //             gpuImageView.setFilter(new GPUImageHueBlendFilter());//Black and white
  //             break;
  //         case 23:
  //             showLog("Exposure filter");
  //             gpuImageView.setFilter(new GPUImageHueFilter(20f));//enverdece
  //             break;
  //         case 24:
  //             showLog("Kuawahara");
  //             gpuImageView.setFilter(new GPUImageKuwaharaFilter());//arte abstracta
  //             break;
  //         case 25:
  //             showLog("Lapacian");
  //             gpuImageView.setFilter(new GPUImageLaplacianFilter());//gris todo
  //             break;
  //         case 26:
  //             showLog("Look up");
  //             gpuImageView.setFilter(new GPUImageLookupFilter(.2f));//obscurese
  //             break;

  //         case 27:
  //             showLog("Monochrome");
  //             gpuImageView.setFilter(new GPUImageMonochromeFilter(1.8f, new float[] {0.2f, 0.5f, 0.2f, 1.0f}));
  //             //old foto
  //             break;

  //         case 28:
  //             showLog("Non maximum");
  //             gpuImageView.setFilter(new GPUImageNonMaximumSuppressionFilter());
  //             //feo
  //             break;

  //         case 29:
  //             showLog("Opacity");
  //             gpuImageView.setFilter(new GPUImageOpacityFilter(.001f));///No hace nada
  //             break;
  //         case 30:
  //             showLog("Overlay");
  //             //obscurese
  //             break;

  //         case 31:
  //             showLog("Posterize");
  //             gpuImageView.setFilter(new GPUImagePosterizeFilter(8));//arte
  //             break;
  //         case 32:
  //             showLog("RGBDilatation");
  //             gpuImageView.setFilter(new GPUImageRGBDilationFilter(2));//fun
  //             break;
  //         case 33:
  //             showLog("RGB");
  //             gpuImageView.setFilter(new GPUImageRGBFilter(1.f,2f,3f));//RGB
  //             break;
  //         case 34:
  //             showLog("Saturation blend");
  //             gpuImageView.setFilter(new GPUImageSaturationBlendFilter());//blanco y negro y verde
  //             break;
  //         case 35:
  //             showLog("Saturation");
  //             gpuImageView.setFilter(new GPUImageSaturationFilter(1.5f));//saturacion
  //             break;

  //         case 36:
  //             showLog("Sepia");
  //             gpuImageView.setFilter(new GPUImageSepiaFilter(.5f));///sephia
  //             break;
  //         case 37:
  //             showLog("Sharpen");
  //             gpuImageView.setFilter(new GPUImageSharpenFilter(10f));//bordos blancos
  //             break;
  //         case 38:
  //             showLog("Sketch");
  //             gpuImageView.setFilter(new GPUImageSketchFilter());//blanco blanco
  //             break;
  //         case 39:
  //             showLog("Smothfilter");
  //             gpuImageView.setFilter(new GPUImageSmoothToonFilter());//turbo arte
  //             break;
  //         case 40:
  //             showLog("SobelTheshold");
  //             gpuImageView.setFilter(new GPUImageSobelThresholdFilter(.8f));//Draw my life
  //             break;
  //         case 41:
  //             showLog("SoftLight");
  //             gpuImageView.setFilter(new GPUImageSoftLightBlendFilter());//baja la luz
  //             break;

  //         case 42:
  //             showLog("Spehererefraction");
  //             gpuImageView.setFilter(new GPUImageSphereRefractionFilter(new PointF(0.5f, 0.5f), 0.5f, 0.5f));//espera
  //             break;

  //         case 43:
  //             showLog("SwirlFilter");
  //             gpuImageView.setFilter(new GPUImageSwirlFilter(.2f,.4f,new PointF(.5f,.5f)));//funny distortion
  //             break;

  //         case 44:
  //             showLog("Toon filter");
  //             gpuImageView.setFilter(new GPUImageToonFilter(0.4f, 9.0f));///Toon
  //             break;

  //         case 45:
  //             showLog("Vignete");
  //             gpuImageView.setFilter(new GPUImageVignetteFilter(new PointF(), new float[] {0.0f, 0.0f, 0.0f}, .4f, 1.5f));//viñeta
  //             break;
  //         case 46:
  //             showLog("Weak pixel");
  //             gpuImageView.setFilter(new GPUImageWeakPixelInclusionFilter());
  //             //raro
  //             break;
  //         case 47:
  //             showLog("White balance");
  //             gpuImageView.setFilter(new GPUImageWhiteBalanceFilter(200f,3f));///balance
  //             break;

  //     }
  // }
    public void showToast(){
        CharSequence text = "No sirve";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }
    public void showLog(String log){
        Log.e("Debug ",log);
    }

}
