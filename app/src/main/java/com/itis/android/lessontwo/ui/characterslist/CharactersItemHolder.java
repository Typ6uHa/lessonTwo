package com.itis.android.lessontwo.ui.characterslist;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itis.android.lessontwo.R;
import com.itis.android.lessontwo.model.character.Character;
import com.itis.android.lessontwo.utils.ImageLoadHelper;

/**
 * Created by Tony on 3/18/2018.
 */

public class CharactersItemHolder extends RecyclerView.ViewHolder {

    private static final int MAX_LENGTH = 80;
    private static final String MORE_TEXT = "...";

    private TextView name;
    private TextView description;
    private ImageView imageView;

    @NonNull
    public static CharactersItemHolder create(@NonNull Context context) {
        View view = View.inflate(context, R.layout.item_character, null);
        CharactersItemHolder holder = new CharactersItemHolder(view);
        return holder;
    }

    public CharactersItemHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_name_character);
        description = itemView.findViewById(R.id.tv_description_character);
        imageView = itemView.findViewById(R.id.iv_cover_character);
    }

    public void bind(@NonNull Character item) {
        name.setText(item.getName());
        if (item.getDescription() != null) {
            description.setText(cutLongDescription(item.getDescription()));
        }
        if (item.getImage() != null) {
            ImageLoadHelper.loadPicture(imageView, String.format("%s.%s", item.getImage().getPath(),
                    item.getImage().getExtension()));
        }
    }

    private String cutLongDescription(String description) {
        if (description.length() < MAX_LENGTH) {
            return description;
        } else {
            return description.substring(0, MAX_LENGTH - MORE_TEXT.length()) + MORE_TEXT;
        }
    }
}