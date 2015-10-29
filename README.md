AwesomePlayerAnim
===================

![](raw/AwesomePlayerAnim.gif)

the gif can't see the effct intuitive, you get the ![.mp4 video](raw/AwesomePlayerAnim.mp4) or ![.apk file](raw/AwesomePlayerAnim.apk) to demonstration.

Usage
=======

It is easy to use, `PlayerAnimHelper` class can do this all. I havn't upload it to the jCenter and you can just copy PlayerAnimHelper.java file to your project then initialize it like

```java
animHelper = new PlayerAnimHelper(ivBg, ivPlay, ivPause);
```

and paly start or stop animation with

```java
animHelper.stopPlayingAnim();
animHelper.startPlayingAnim();
```

Three params in the constructor is

- ivBg: a view of background
- ivPlay: a view of the playing image
- ivPause: a view of the pausing image

Demo
=======

create a layout resource like below

```xml
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/fl"
    android:layout_width="269dp"
    android:layout_height="269dp"
    android:layout_centerInParent="true">

    <ImageView
        android:id="@+id/ivBg"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/pausing_bg" />

    <ImageView
        android:id="@+id/ivPlay"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"
        android:src="@drawable/play" />

    <ImageView
        android:id="@+id/ivPause"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"
        android:src="@drawable/pause"
        android:visibility="gone" />
</FrameLayout>
```

find the view in this resource

```java
View ivBg = findViewById(R.id.ivBg);
View ivPlay = findViewById(R.id.ivPlay);
View ivPause = findViewById(R.id.ivPause);
```

then you can just create a PlayerAnimHelper, be careful with the visibility of ivPlay and ivPause

```java
PlayerAnimHelper animHelper = new PlayerAnimHelper(ivBg, ivPlay, ivPause);
```

using stopPlayingAnim(), startPlayingAnim() for animations

License
=======

    Copyright 2015 Tim Qi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
