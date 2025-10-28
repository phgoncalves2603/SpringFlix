package com.SpringFlix.SpringFlix.mapper;

import com.SpringFlix.SpringFlix.dto.StreamingDTO;
import com.SpringFlix.SpringFlix.model.StreamingModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class  StreamingMapper {
    public static StreamingDTO map(StreamingModel streamingModel){
        StreamingDTO streamingDTO = new StreamingDTO();
        streamingDTO.setId(streamingModel.getId());
        streamingDTO.setName(streamingModel.getName());


        return streamingDTO;
    }
    public static StreamingModel map(StreamingDTO streamingDTO){
        StreamingModel streamingModel= new StreamingModel();
        streamingModel.setId(streamingDTO.getId());
        streamingModel.setName(streamingDTO.getName());
        return  streamingModel;
    }
}
