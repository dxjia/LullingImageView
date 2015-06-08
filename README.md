# LullingImageView
a lulling image view.缓慢放大效果的imageView，只是imageVIew里的图片变化，不影响imageview本身尺寸。

# ScreenShot
![image](https://github.com/dxjia/LullingImageView/blob/master/screenshot.gif)

# Example Usage
```xml
 <com.dxjia.lulling.LullingImageView
        android:id="@+id/test1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/test1"
        app:autoPlay="true"
        app:scaleValue="1.2"
        app:duration="6000"/>
```	
#TODO
    to correct exatlly size function
# Thanks
[NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)