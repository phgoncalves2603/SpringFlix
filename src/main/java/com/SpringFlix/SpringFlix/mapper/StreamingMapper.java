package com.SpringFlix.SpringFlix.dto;

import com.SpringFlix.SpringFlix.model.StreamingModel;

public class StreamingMapper {
    public StreamingDTO map(StreamingModel streamingModel){
        StreamingDTO streamingDTO = new StreamingDTO();
        streamingDTO.setId(streamingModel.getId());
        streamingDTO.setName(streamingModel.getName());


        return streamingDTO;
    }
    public StreamingModel map(StreamingDTO streamingDTO){
        StreamingModel streamingModel= new StreamingModel();
        streamingModel.setId(streamingDTO.getId());
        streamingModel.setName(streamingDTO.getName());
        return  streamingModel;
    }
}
