package br.com.frameworksystem.marvelapp.api;

import br.com.frameworksystem.marvelapp.model.CharactersDto;
import br.com.frameworksystem.marvelapp.model.MarvelResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface CharacterApi {
    @GET("/v1/public/characters")
    Observable<MarvelResponse<CharactersDto>> getAll(@Query("limit") Integer limit,
                                                     @Query("offset") Integer offset, @Query("orderBy") String orderBy);
}
