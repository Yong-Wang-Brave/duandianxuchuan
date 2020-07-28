import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 * @author riemann
 * @date 2019/04/24 23:22
 */
public class FileAccessI implements Serializable {


/*    public void seek(long pos)
            throws IOException
    设置到此文件开头测量到的文件指针偏移量*/


    RandomAccessFile oSavedFile;
    long nPos;

    public FileAccessI() throws IOException
    {
        this("", 0);
    }

    public FileAccessI(String sName, long nPos) throws IOException
    {
        oSavedFile = new RandomAccessFile(sName, "rw");
        this.nPos = nPos;
        oSavedFile.seek(nPos);
    }

/*    write
    public void write(byte[] b,
                      int off,
                      int len)
            throws IOException
    将 len 个字节从指定 byte 数组写入到此文件，并从偏移量 off 处开始。*/


    public synchronized int write(byte[] b, int nStart, int nLen)
    {
        int n = -1;
        try
        {
            oSavedFile.write(b, nStart, nLen);
            n = nLen;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return n;
    }
}