package com.lzy.imagepickerdemo.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.lzy.imagepickerdemo.imageloader.GlideImageLoader;


/**
 * author: jiangtao.liang
 * date:   On 2018/11/9 11:19
 */
@Deprecated
public class ImagePickerHelper {

    private ImagePickerHelper() {
    }

    private static volatile ImagePickerHelper sInstance = null;

    public synchronized static ImagePickerHelper getInstance() {
        if (sInstance == null) {
            sInstance = new ImagePickerHelper();
        }
        return sInstance;
    }

    public void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(false);  //显示拍照按钮
        imagePicker.setCrop(false);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setMultiMode(false);
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(300);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(300);//保存文件的高度。单位像素
    }

    /**
     * 调用相机
     */
    private void openCamera(Fragment context, int requestCode) {
        Intent intent = new Intent(context.getActivity(), ImageGridActivity.class);
        intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * 调用相机
     */
    private void openCamera(Activity context, int requestCode) {
        Intent intent = new Intent(context, ImageGridActivity.class);
        intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
        context.startActivityForResult(intent, requestCode);
    }

    public void requestCameraPermission(final Fragment context, final int requestCode) {
        openCamera(context, requestCode);

    }

    public void requestCameraPermission(final Activity context, final int requestCode) {
        openCamera(context, requestCode);

    }

    public void openAlbum(final Fragment context, final int requestCode) {
        Intent intent = new Intent(context.getActivity(), ImageGridActivity.class);
        context.startActivityForResult(intent, requestCode);
    }

    public void openAlbum(final Activity context, final int requestCode) {
        Intent intent = new Intent(context, ImageGridActivity.class);
        context.startActivityForResult(intent, requestCode);
    }
}
