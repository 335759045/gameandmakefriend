package app.my.br.com.baserecyclerview.adapter.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by 陈志坚 on 2016/12/2.
 */

public class FrescoCompressUtils {

    public static void displayImage(Context context , Uri uri, SimpleDraweeView draweeView){
        if((context == null || TextUtils.isEmpty(uri.toString())) || draweeView == null){
            return;
        }
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(MetricsUtil.dip2px(context,300), MetricsUtil.dip2px(context,300)))
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }
}
