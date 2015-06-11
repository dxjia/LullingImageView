# LullingImageView
a lulling image view.<br>
缓慢缩放效果的imageView，只是imageVIew里的图片变化，不影响imageview本身尺寸。<br>
原型效果来源于豌豆荚的《开眼》app。

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
    to correct exatlly size function<br>
    使用ScaleDrawable重新设计
# Thanks
[NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)

# License
```
Copyright (C) 2015 dxjia

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
