package br.com.frameworksystem.marvelapp.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Character;
import br.com.frameworksystem.marvelapp.model.MarvelImage;
import br.com.frameworksystem.marvelapp.ui.activities.CharacterDetailActivity;


/**
 * Created by wgomes on 17/06/16.
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private Context context;
    private List<Character> characters;
    private RecyclerView recyclerView;

    public CharacterAdapter(Context context, List<Character> characteres, RecyclerView recyclerView) {
        this.context = context;
        this.characters = characteres;
        this.recyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_character, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Character character = characters.get(position);
        Picasso.with(context).load(character.thumbnail.getImageUrl(MarvelImage.Size.DETAIL)).centerCrop().resize(200,200).into(holder.characterImage);
        holder.characterDescription.setText(character.getDescription());
        holder.characterName.setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView characterImage;
        TextView characterDescription;
        TextView characterName;

        public ViewHolder(View itemView) {
            super(itemView);

            characterImage = (ImageView) itemView.findViewById(R.id.character_image);
            characterDescription = (TextView) itemView.findViewById(R.id.character_description);
            characterName = (TextView) itemView.findViewById(R.id.character_name);

            itemView.setOnClickListener(onClickListener);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = recyclerView.getChildAdapterPosition(v);
                Character character = characters.get(position);

                Intent intent = new Intent(context, CharacterDetailActivity.class);
                intent.putExtra("character", character);
                context.startActivity(intent);
            }
        };

    }
}


