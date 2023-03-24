package nus.iss.edu.server.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Bgg {

    private List<Games> gameList = new LinkedList<>();
    private Integer offset;
    private Integer limit;
    private Long total;
    private Date timestamp;
    public List<Games> getGameList() {
        return gameList;
    }
    public void setGameList(List<Games> gameList) {
        this.gameList = gameList;
    }
    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    
    
}
