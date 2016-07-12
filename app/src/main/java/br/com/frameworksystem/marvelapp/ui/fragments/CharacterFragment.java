package br.com.frameworksystem.marvelapp.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.frameworksystem.marvelapp.Mock;
import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.api.CharacterApi;
import br.com.frameworksystem.marvelapp.api.RemoteAdapter;
import br.com.frameworksystem.marvelapp.model.Character;
import br.com.frameworksystem.marvelapp.model.CharactersDto;
import br.com.frameworksystem.marvelapp.model.MarvelResponse;
import br.com.frameworksystem.marvelapp.ui.adapters.CharacterAdapter;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CharacterFragment extends Fragment {

        private RecyclerView recyclerView;
        private CharacterAdapter characterAdapter;


        public static Fragment newInstance() {
            return new CharacterFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_recycler, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            int collum = getResources().getInteger(R.integer.personagem_collum);

            GridLayoutManager layoutManager =
                    new GridLayoutManager(getActivity(), collum);

            recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
            recyclerView.setLayoutManager(layoutManager);

            final ArrayList<Character> list = new ArrayList<>();

            Observable<MarvelResponse<CharactersDto>> remote = RemoteAdapter.getApi(CharacterApi.class).getAll(20,1,null);
            remote.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<MarvelResponse<CharactersDto>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(MarvelResponse<CharactersDto> charactersDtoMarvelResponse) {
                     list.addAll(charactersDtoMarvelResponse.data.results);
                }
            });


            characterAdapter = new CharacterAdapter(getActivity(), list , recyclerView);
            recyclerView.setAdapter(characterAdapter);

        }



}
