package my.group.MR;

import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.Mapper;

import java.io.IOException;
import java.util.Iterator;

/**
 * Mapper模板。请用真实逻辑替换模板内容
 */
public class MyMapper implements Mapper {
    private Record word;
    private Record one;

    public void setup(TaskContext context) throws IOException {
    	word = context.createMapOutputKeyRecord();
    	one = context.createMapOutputValueRecord();
    	one.setBigint(0, 1L);
    	/*
    	Iterator<Record> rs =context.readResourceTable("cx_resource_source");
        while (rs.hasNext()) {
            Record val = rs.next();
            for(int i =0;i<val.getColumnCount() ; i++){
                word.setString(0, val.get(i).toString());
                context.write(word, one);
            }
        }*/
    }

    public void map(long recordNum, Record record, TaskContext context) throws IOException {
        String w = record.getString(0);
        String v = record.getString(1);
        word.setString(0, w+" "+v);
        context.write(word, one);
    }

    public void cleanup(TaskContext context) throws IOException {

    }
}