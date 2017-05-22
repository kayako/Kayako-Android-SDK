package com.kayako.sdk.android.k5.messenger.attachmentpreview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kayako.sdk.android.k5.R;
import com.kayako.sdk.android.k5.activities.KayakoAttachmentPreviewActivity;
import com.kayako.sdk.android.k5.common.utils.ImageUtils;

import java.io.File;

public class AttachmentPreviewFragment extends Fragment {

    private View mRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.ko__fragment_attachment_preview, container, false);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRoot.findViewById(R.id.ko__button_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishByExit();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!(getActivity() instanceof KayakoAttachmentPreviewActivity)) {
            throw new IllegalStateException("This fragment is meant to be used with KayakoAttachmentPreviewActivity");
        }

        Bundle bundle = getActivity().getIntent().getExtras();

        boolean showSendButton = bundle.getBoolean(KayakoAttachmentPreviewActivity.ARG_SHOW_SEND_BUTTON, false);
        String imageUrl = bundle.getString(KayakoAttachmentPreviewActivity.ARG_IMAGE_URL);
        String filePath = bundle.getString(KayakoAttachmentPreviewActivity.ARG_FILE_PATH);

        ImageView imageView = ((ImageView) mRoot.findViewById(R.id.ko__attachment_image));
        if (imageUrl != null) {
            ImageUtils.loadUrlAsAttachmentImage(getContext(), imageView, imageUrl, false);

        } else if (filePath != null) {
            ImageUtils.loadFileAsAttachmentImage(getContext(), imageView, new File(filePath), false);

        } else {
            throw new IllegalStateException("INVALID STATE - need at least imageUrl or filePath");
        }

        View exitButton = mRoot.findViewById(R.id.ko__button_exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishByExit();
            }
        });

        View sendButton = mRoot.findViewById(R.id.ko__reply_box_send_button);
        if (showSendButton) {
            sendButton.setVisibility(View.VISIBLE);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishByClickingSend();
                }
            });
        } else {
            sendButton.setVisibility(View.GONE);
        }
    }

    public void finishByExit() {
        if (getActivity() == null) {
            return;
        }

        getActivity().setResult(KayakoAttachmentPreviewActivity.RESULT_EXIT);
        getActivity().onBackPressed(); // not finish() to retain animation
    }

    public void finishByClickingSend() {
        if (getActivity() == null) {
            return;
        }

        getActivity().setResult(KayakoAttachmentPreviewActivity.RESULT_SEND);
        getActivity().finish(); // needs finish to pass result code and animation not required here
    }

}
