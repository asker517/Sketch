/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.sketch.display;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import me.xiaopan.sketch.request.ImageViewInterface;

/**
 * 默认的图片显示器，没有任何动画效果
 */
public class DefaultImageDisplayer implements ImageDisplayer {
    protected String logName = "DefaultImageDisplayer";
    private boolean alwaysUse;

    @Override
    public void display(ImageViewInterface imageViewInterface, Drawable newDrawable) {
        if (newDrawable == null) {
            return;
        }
        imageViewInterface.clearAnimation();
        imageViewInterface.setImageDrawable(newDrawable);
    }

    @SuppressWarnings("unused")
    public DefaultImageDisplayer setAlwaysUse(boolean alwaysUse) {
        this.alwaysUse = alwaysUse;
        return this;
    }

    @Override
    public boolean isAlwaysUse() {
        return alwaysUse;
    }

    @Override
    public String getIdentifier() {
        return logName;
    }

    @Override
    public StringBuilder appendIdentifier(String join, StringBuilder builder) {
        if (!TextUtils.isEmpty(join)) {
            builder.append(join);
        }
        return builder.append(logName).append("(alwaysUse=").append(alwaysUse).append(")");
    }
}
