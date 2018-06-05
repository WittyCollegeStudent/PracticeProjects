import com.jcraft.jsch.*;
import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.FtpClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
//        try{
//            String host = "193.112.70.161";
//            int port = 22;
//            String targetSftpUsername = "ubuntu";
//            String targetSftpPassword = "nS42kuZbLKVy9mGq";
//            String srcFilePath = "C:\\Users\\witty\\Desktop\\新建文本文档.txt";//源文件的路径
//            String targetSftpFilePath = "/home/ubuntu/";
//            //分隔字符串获取源文件名
//            String strs[] = srcFilePath.split("\\\\");
//            String localFileName = strs[strs.length - 1];
//            SftpUtil sftpUtil = new SftpUtil(host, port, targetSftpUsername, targetSftpPassword);
//            sftpUtil.connect();
//            //1.删除远程localFileName.tmp文件
//            if(sftpUtil.existsFile(targetSftpFilePath + localFileName + ".tmp")){
//                sftpUtil.deleteSFTP(targetSftpFilePath,localFileName + ".tmp");
//            }
//            //2.将fileAbsolutePath文件的真实文件名加.tmp上传到targetSftpFilePath下
//            sftpUtil.uploadFile(targetSftpFilePath, srcFilePath, localFileName + ".tmp");
//            //3.将targetSftpFilePath下与真实文件名localFileName相同的文件删除,将localFileName.tmp文件重命名为localFileName
//            if(sftpUtil.existsFile(targetSftpFilePath + localFileName)){
//                sftpUtil.deleteSFTP(targetSftpFilePath, localFileName);
//            }
//            sftpUtil.rename(targetSftpFilePath + localFileName + ".tmp", targetSftpFilePath + localFileName);
//            sftpUtil.disconnect();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//        }

//        //目标
//        String targetProtocol = "ftp";
//        String targetHost = "193.112.70.161";
//        int targetPort = 21;
//        String targetUsername = "ubuntu";
//        String targetPassword = "nS42kuZbLKVy9mGq";
//        String targetFilePath = "/home/ubuntu/aaaaaa/www恒生.txt";
//        //源
//        String sourceProtocol = "ftp";
//        String sourceHost = "qxu1649540478.my3w.com";
//        int sourcePort = 21;
//        String sourceUsername = "qxu1649540478";
//        String sourcePassword = "aliyun123123";
//        String sourceFilePath = "/htdocs/www恒生.txt";
        
        //源
        String sourceProtocol = "ftp";
        String sourceHost = "193.112.70.161";
        int sourcePort = 21;
        String sourceUsername = "ubuntu";
        String sourcePassword = "nS42kuZbLKVy9mGq";
        String sourceFilePath = "/home/ubuntu/www恒生.txt";
        //目标
        String targetProtocol = "ftp";
        String targetHost = "qxu1649540478.my3w.com";
        int targetPort = 21;
        String targetUsername = "qxu1649540478";
        String targetPassword = "aliyun123123";
        String targetFilePath = "/htdocs/www恒生.txt";

        InputStream inputStream = null;//源输入流,它在upload方法最后会被关闭
        FtpUtil ftpUtil = null;
        SftpUtil sftpUtil = null;
        Session sourceSession = null;//源ssh会话，用来建立sftp连接
        Session targetSession = null;
        ChannelSftp sourceSftp = null;//源sftp连接
        ChannelSftp targetSftp = null;
        FTPClient sourceFtp = null;//源ftp连接
        FTPClient targetFtp = null;
        //获取输入流
        if(sourceProtocol.equals("sftp")){
            System.out.println("源建立SFTP连接");
            sftpUtil = SftpUtil.getSftpUtilSingleInstance();
            sourceSession = sftpUtil.getConnectedSession(sourceUsername, sourcePassword, sourceHost, sourcePort);
            sourceSftp = sftpUtil.getConnectedSftp(sourceSession);
            inputStream = sftpUtil.getInputStream(sourceSftp, sourceFilePath);
        }else if(sourceProtocol.equals("ftp")){
            ftpUtil = FtpUtil.getFtpUtilSignleInstance();
            sourceFtp = ftpUtil.getConnectedFTPClient(sourceHost, sourcePort, sourceUsername, sourcePassword);
            inputStream = ftpUtil.getInputStream(sourceFtp, sourceFilePath);
        }else {
            System.out.println("源协议配置错误");
        }
        try {
//            sourceSftp.cd("/home/ubuntu");
            sourceFtp.enterLocalPassiveMode();
            sourceFtp.changeWorkingDirectory("/home/ubuntu");
            System.out.println(sourceFtp.printWorkingDirectory());
            sourceFtp.makeDirectory("a/b");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sourceFtp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        //获取输出流
//        if(targetProtocol.equals("sftp")){
//            System.out.println("目标建立SFTP连接");
//            sftpUtil = SftpUtil.getSftpUtilSingleInstance();
//            targetSession = sftpUtil.getConnectedSession(targetUsername, targetPassword, targetHost, targetPort);
//            targetSftp = sftpUtil.getConnectedSftp(targetSession);
//            sftpUtil.uploadFile(targetSftp, inputStream, targetFilePath);
//        }else if(targetProtocol.equals("ftp")){
//            System.out.println("目标建立FTP连接");
//            ftpUtil = FtpUtil.getFtpUtilSignleInstance();
//            targetFtp = ftpUtil.getConnectedFTPClient(targetHost, targetPort, targetUsername, targetPassword);
//            ftpUtil.uploadFile(targetFtp, targetFilePath, inputStream);
//        }else{
//            System.out.println("目标协议配置错误");
//        }
//        //关闭连接
//        if(sourceSession != null){
//            sftpUtil.disconnect(sourceSession, sourceSftp);
//        }
//        if(targetSession != null){
//            sftpUtil.disconnect(targetSession, targetSftp);
//        }
//        try {
//            if(sourceFtp != null){
//                sourceFtp.disconnect();
//            }
//            if(targetFtp != null){
//                targetFtp.disconnect();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

class SftpUtil {

    private static SftpUtil sftpUtil = null;

    private SftpUtil(){}

    /**
     * 获得工具类单例
     * */
    public static SftpUtil getSftpUtilSingleInstance() {
        if(sftpUtil == null){
            return new SftpUtil();
        }else{
            return sftpUtil;
        }
    }

    /**
     * 显示是否存在此文件
     * */
    public boolean existsFile(ChannelSftp sftp, String path){
        try {
            Vector v = sftp.ls(path);
            if(v.size() > 0){
                return true;
            }
        } catch (SftpException e) {
//            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除stfp文件
     * @param directory：要删除文件所在目录
     * @param deleteFile：要删除的文件
     */
    public void deleteSFTP(ChannelSftp sftp, String directory, String deleteFile)
    {
        try
        {
            // sftp.cd(directory);
            sftp.rm(directory + deleteFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
    * 重命名文件
     * @param sftp
     * @param oldpath 原名称
     * @param newpath 新名称
    * */
    public void rename(ChannelSftp sftp, String oldpath, String newpath){
        try {
            sftp.rename(oldpath,newpath);
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }


    /**
     * 建立ssh连接
     * */
    public Session getConnectedSession(String username, String password, String host, int port){
        JSch jsch = new JSch();
        Session sshSession = null;
        try {
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(properties);
            sshSession.connect();
            return sshSession;
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 连接sftp服务器
     * @return ChannelSftp sftp类型
     */
    public ChannelSftp getConnectedSftp(Session sshSession){
        //连接STP服务器部分

        ChannelSftp sftp = null;
        try {

            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return sftp;
    }

    /**
     * 关闭连接
     */
    public void disconnect(Session sshSession, ChannelSftp sftp) {
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (sshSession != null) {
            if (sshSession.isConnected()) {
                sshSession.disconnect();
            }
        }
    }


    /**
     * 根据文件路径获取输入流,这个输入流是用来上传文件到目标主机的
     * */
    public InputStream getInputStream(ChannelSftp sftp, String filePath){
        try {
            return sftp.get(filePath);
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传单个文件
     *
     * @param sftp
     * @param inputStream    文件输入流
     * @param targetFilePath 要上传的文件 如：D:\\test\\xxx.txt
     */
    public void uploadFile(ChannelSftp sftp, InputStream inputStream, String targetFilePath) {
        String strs[] = targetFilePath.split("/");
        String fileName = strs[strs.length - 1];
        String targetDir = targetFilePath.substring(0, targetFilePath.lastIndexOf("/"));
        //上传部分
        try {
            sftp.cd(targetDir);
        } catch (SftpException e) {
            try {
                sftp.mkdir(targetDir);
                sftp.cd(targetDir);
            } catch (SftpException e1) {
                e1.printStackTrace();
            }

        }
        try {
            sftp.put(inputStream, fileName);
            System.out.println("上传文件:" + targetFilePath + "成功");
        } catch (SftpException e) {
            System.out.println("上传文件:" + targetFilePath + "失败");
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}