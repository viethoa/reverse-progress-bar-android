Countdown and Reverse progressbar
-----

I am working on to make better, now it's just have some little property. If anyone want to make something special, feel free to ask me.
Support Sdk Version 7 to latest.

Properties
-----
- setMax: set progress max.
- setProgress: set current progress.
- setColor: set stroke color.
- setStrokeWidth: set width of the stroke.
- strockCap: using that to make cap when progressing.

![](https://github.com/viethoa/image-repositories/blob/master/reverse-progress-bar.gif "reverse progress bar")

Dependency
-----
    dependencies {
        Coming soon
    }

    **Or**:

    Download this project and import library in there.

How to use
-----
**Step 1:** add xml: please set Width and Height for it.

    <com.viethoa.reverseprogressbar.ReverseProgressBar
            android:id="@+id/reverse_progress_bar"
            android:layout_width="120dp"
            android:layout_height="120dp"
            android:layout_gravity="center" />

**Step 2:** config in your code:

        reverseProgressBar.setMax(progress);
        reverseProgressBar.setProgress(progress);
        reverseProgressBar.setStrokeWidth(STROKE_WIDTH);
        reverseProgressBar.strockCap(true);

License
-------

    Copyright 2015 Khuat Viet Hoa

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



