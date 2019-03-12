package io.stayhungrystayfoolish.github.grpcjava.web.grpc;

import io.grpc.stub.StreamObserver;
import io.stayhungrystayfoolish.github.grpcjava.domain.Dictionary;
import io.stayhungrystayfoolish.github.grpcjava.grpc.DictionaryServiceGrpc;
import io.stayhungrystayfoolish.github.grpcjava.grpc.Information;
import net.badata.protobuf.converter.Converter;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 4:26 PM
 *
 * @Description:
 * @Version: 1.0
 */
@GrpcService(DictionaryServiceGrpc.class)
public class InformationProvider extends DictionaryServiceGrpc.DictionaryServiceImplBase {

    private final Logger logger = LoggerFactory.getLogger(InformationProvider.class);

//    @Override
//    public void selectorDictionary(Information.DictionaryRequest request, StreamObserver<Information.DictionaryResponse> responseObserver) {
//
//        String parent = request.getParent();
//        String language = request.getLanguage();
//
//        // TODO: 2019/3/11 db data
//        List<Dictionary> dictionaries = new ArrayList<>();
//        Dictionary d = new Dictionary();
//        d.setId(1L);
//        d.setParent("root");
//        d.setName("about-us");
//        dictionaries.add(d);
//
//        List<Information.Dictionary> dictionaryList = new ArrayList<>();
//        Information.Dictionary.Builder di;
//        for (Dictionary dict : dictionaries) {
//            di = Information.Dictionary.newBuilder();
//            di.setId(dict.getId());
//            di.setParent(dict.getParent());
//            di.setName(dict.getName());
//            dictionaryList.add(di.build());
//        }
//
//        // ---------
//
//        Information.DictionaryResponse.Builder builder = Information.DictionaryResponse.newBuilder();
//        builder.addAllDictionary(dictionaryList);
//
//        Information.DictionaryResponse response = builder.build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//
//
////        Dictionary bean = new Dictionary();
////        Information.Dictionary i = Converter.create().toProtobuf(Information.Dictionary.class, bean);
////        Dictionary entity = Converter.create().toDomain(Dictionary.class, i);
//    }

    @Override
    public void selectorDictionary(Information.DictionaryRequest request, StreamObserver<Information.DictionaryResponse> responseObserver) {

        String parent = request.getParent();
        String language = request.getLanguage();

        // TODO: 2019/3/11 db data
        List<Dictionary> dictionaries = new ArrayList<>();
        Dictionary d = new Dictionary();
        d.setId(1L);
        d.setParent("root");
        d.setName("about-us");
        dictionaries.add(d);
        dictionaries.add(d);
        dictionaries.add(d);

        List<Information.Dictionary> dictionary = Converter.create().toProtobuf(Information.Dictionary.class, dictionaries);

        // ---------

        Information.DictionaryResponse.Builder builder = Information.DictionaryResponse.newBuilder();
        builder.addAllDictionary(dictionary);

        Information.DictionaryResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();


//        Dictionary bean = new Dictionary();
//        Information.Dictionary i = Converter.create().toProtobuf(Information.Dictionary.class, bean);
//        Dictionary entity = Converter.create().toDomain(Dictionary.class, i);
    }

    @Override
    public void selectorDictionaryPage(Information.DictionaryPageRequest request, StreamObserver<Information.DictionaryPageResponse> responseObserver) {


        Information.PageRequest pageRequest = request.getPage();
        Integer pageNumber = pageRequest.getPageNumber();
        Integer pageSize = pageRequest.getPageSize();
        String pageSort = pageRequest.getSort();
        String sortType = pageSort.split(",")[0];
        String sortFields = pageSort.split(",")[1];

        //判断排序类型及排序字段
        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortFields) : new Sort(Sort.Direction.DESC, sortFields);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        // TODO: 2019/3/12 add db page request

        List<Dictionary> dictionaries = new ArrayList<>();
        Dictionary d = new Dictionary();
        d.setId(1L);
        d.setParent("root");
        d.setName("about-us");
        dictionaries.add(d);


        List<Information.Dictionary> dictionaryList = new ArrayList<>();
        Information.Dictionary.Builder di;
        for (Dictionary dict : dictionaries) {
            di = Information.Dictionary.newBuilder();
            di.setId(dict.getId());
            di.setParent(dict.getParent());
            di.setName(dict.getName());
            dictionaryList.add(di.build());
        }


        Information.DictionaryResponse.Builder re = Information.DictionaryResponse.newBuilder();
        re.addAllDictionary(dictionaryList);

        Map<String, Information.DictionaryResponse> map = new HashMap<>();
        map.put("content", re.build());

        Information.DictionaryPageResponse.Builder builder = Information.DictionaryPageResponse.newBuilder();
        builder.setTotalPages(10);
        builder.setTotalElements(50);
        builder.setFirst(true);
        builder.setLast(false);

        builder.putAllContent(map);


        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();

    }
}
