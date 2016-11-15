package com.example.ok.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.csdn.Weight.ImageView.ClipImageView;
import com.csdn.Weight.ImageView.CropImageView;
import com.csdn.Weight.ImageView.crop.Crop;
import com.csdn.Weight.ImageView.crop.util.FileUtils;
import com.csdn.Weight.ImageView.displayers.CircleBitmapDisplayer;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

public class CropImgActivity extends BaseActivity {

    //private CropImageView userAvater;
    //private com.csdn.Weight.ImageView.ClipImageView userAvater2;
    private static final int REQUEST_CODE_CAPTURE_CAMEIA = 1458;

    private ImageView mImageView;

    private String mCurrentPhotoPath;

    private CheckBox mCheckBox;

    private File mTempDir;

    private ImageView mCircleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_img);
       // this.userAvater2 = (ClipImageView) findViewById(R.id.userAvater2);
       // this.userAvater = (CropImageView) findViewById(R.id.userAvater);


        mImageView = (ImageView) findViewById(R.id.imageview);
        mCircleView = (ImageView) findViewById(R.id.imageview_circle);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox);
        mTempDir = new File(Environment.getExternalStorageDirectory(), "Temp");
        if (!mTempDir.exists()) {
            mTempDir.mkdirs();
        }

    /*    userAvater.setDrawable(getResources().getDrawable(R.drawable.a), 300,
                300);

        userAvater2.setClipFrameBorderWidth(2);
        userAvater2.setClipFrameSize(300,300);
        userAvater2.setImageDrawableSecure(getResources().getDrawable(R.drawable.a));*/
    }

    public void takePicktrue(View v) {
        getImageFromCamera();
    }

    public void pickImage(View v) {
        Crop.pickImage(this);
    }

    protected void getImageFromCamera() {
        // create Intent to take a picture and return control to the calling
        // application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String fileName = "Temp_camera" + String.valueOf(System.currentTimeMillis());
        File cropFile = new File(mTempDir, fileName);
        Uri fileUri = Uri.fromFile(cropFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file
        // name
        mCurrentPhotoPath = fileUri.getPath();
        // start the image capture Intent
        startActivityForResult(intent, REQUEST_CODE_CAPTURE_CAMEIA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        System.out.println(" onActivityResult result.getData() " + ((result == null) ? "null" : result.getData()));
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == Crop.REQUEST_PICK) {
                beginCrop(result.getData());
            } else if (requestCode == Crop.REQUEST_CROP) {
                handleCrop(resultCode, result);
            } else if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA) {
                System.out.println(" REQUEST_CODE_CAPTURE_CAMEIA " + mCurrentPhotoPath);
                if (mCurrentPhotoPath != null) {
                    beginCrop(Uri.fromFile(new File(mCurrentPhotoPath)));
                }
            }
        }
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == Activity.RESULT_OK) {
            System.out.println(" handleCrop: Crop.getOutput(result) " + Crop.getOutput(result));
            mImageView.setImageURI(Crop.getOutput(result));
//            mCircleView.setImageBitmap( getCircleBitmap(Crop.getOutput(result)));
        } else if (resultCode == Crop.RESULT_ERROR) {
//            Toast.makeText(getActivity(), Crop.getError(result).getMessage(),
//                    Toast.LENGTH_SHORT).show();
        }
    }

    private Bitmap getCircleBitmap(Uri uri) {
        Bitmap src = BitmapFactory.decodeFile(uri.getPath());
        Bitmap output = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, src.getWidth(), src.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(src.getWidth() / 2, src.getWidth() / 2, src.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src, rect, rect, paint);
        return output;
    }

    private void beginCrop(Uri source) {
        boolean isCircleCrop = mCheckBox.isChecked();
        String fileName = "Temp_" + String.valueOf(System.currentTimeMillis());
        File cropFile = new File(mTempDir, fileName);
        Uri outputUri = Uri.fromFile(cropFile);
        new Crop(source).output(outputUri).setCropType(isCircleCrop).start(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTempDir.exists()) {
            FileUtils.deleteFile(mTempDir);
        }
    }

}
