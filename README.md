# ImagePicker for Android

## [原作者地址](https://github.com/jeasonlzy/ImagePicker),因作者不再维护，存在些许bug，复制一份自我维护，修复若干bug，并已经发布到了jcenter
<br>

## Requirements
* Android miniSDK 16 

## Usage

### Gradle dependency

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.moonljt521.imagepicker:imagepicker:1.1.3'
}
```

### Sample Code
With preview:

```java
// you can init this in application ，
private ImagePicker imagePicker;
imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
imagePicker.setShowCamera(false);  //显示拍照按钮
imagePicker.setCrop(false);        //允许裁剪（单选才有效）
imagePicker.setSaveRectangle(true); //是否按矩形区域保存
imagePicker.setMultiMode(false);
imagePicker.setSelectLimit(1);    //选中数量限制
imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
imagePicker.setOutPutX(300);   //保存文件的宽度。单位像素
imagePicker.setOutPutY(300);  //保存文件的高度。单位像素

// call camera
Intent intent = new Intent(context.getActivity(), ImageGridActivity.class);
intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
context.startActivityForResult(intent, requestCode);

// start album
Intent intent = new Intent(context.getActivity(), ImageGridActivity.class);
context.startActivityForResult(intent, requestCode);

// receive the result data
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 100) {
                // ...
        } else {
                Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }
}

```

### Gradle
Make sure that you run the clean target when using maven.

```groovy
gradle clean assemble
```

