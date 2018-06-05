import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class FtpDemo {

    public static void main(String args[]) throws IOException {
        //源
        String srcHostname = "193.112.70.161";
        int srcPort = 21;
        String srcUsername = "ubuntu";
        String srcPassword = "nS42kuZbLKVy9mGq";
        String srcFilePath = "/home/ubuntu/www恒生.txt";
        String fileName = "www恒生.txt";
        //目标
        String dstHostname = "qxu1649540478.my3w.com";
        int dstPort = 21;
        String dstUsername = "qxu1649540478";
        String dstPassword = "aliyun123123";
        String dstFilePath = "/htdocs/werw/www恒生.txt";
        FtpUtil ftpUtil = FtpUtil.getFtpUtilSignleInstance();
        FTPClient srcClient = ftpUtil.getConnectedFTPClient(srcHostname, srcPort, srcUsername, srcPassword);
        FTPClient dstClient = ftpUtil.getConnectedFTPClient(dstHostname, dstPort, dstUsername, dstPassword);
        InputStream inputStream = ftpUtil.getInputStream(srcClient, srcFilePath);
        ftpUtil.uploadFile(dstClient, dstFilePath, inputStream);
        ftpUtil.closeFtpClient(srcClient);
        ftpUtil.closeFtpClient(dstClient);
    }

}
class FtpUtil{

    private static FtpUtil ftpUtil = null;

    private FtpUtil(){}

    /**
     * 获得工具类单例
     * */
    public static FtpUtil getFtpUtilSignleInstance() {
        if(ftpUtil == null){
            return new FtpUtil();
        }else{
            return ftpUtil;
        }
    }

    public FTPClient getConnectedFTPClient(String hostname, Integer port, String username, String password) {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setAutodetectUTF8(true);
        ftpClient.setControlEncoding("UTF-8");//这里如果用utf8的话，会有乱码产生
        try {
            ftpClient.connect(hostname, port); //连接ftp服务器
            ftpClient.login(username, password); //登录ftp服务器
            int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
            ftpClient.enterLocalPassiveMode();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return ftpClient;
    }

    public void closeFtpClient(FTPClient ftpClient){
        if(ftpClient.isConnected()){
            try{
                ftpClient.logout();
                ftpClient.disconnect();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

//    /**
//     * 从一个ftp服务器上传文件到另一个ftp服务器
//     * @param targetDir ftp服务保存地址
//     * @param fileName 上传到ftp的文件名
//     *  @param srcDir 待上传文件的名称（绝对地址） *
//     * @return
//     */
//    public void uploadFileFromFtp(FTPClient srcClient, FTPClient targetClient, String targetDir, String fileName, String srcDir){
//
//        if(targetDir.charAt(targetDir.length() - 1) != '/'){
//            targetDir += "/";
//        }
//        if(srcDir.charAt(srcDir.length() - 1) != '/'){
//            srcDir += "/";
//        }
//        srcClient.enterLocalPassiveMode();
//        String fileNameTemp = fileName + ".tmp";
//        InputStream inputStream = null; //源ftp输入流
//        OutputStream outputStream = null; //目标ftp输出流
//        try{
////            inputStream = new FileInputStream(new File(srcFileAbsoPath));
//            //1.删除targetFilePath下文件名为fileName.tmp的文件,如fund_inc.js就是fund_inc.js.tmp
//            deleteFile(targetClient, targetDir, fileNameTemp);
//            targetClient.setFileType(targetClient.BINARY_FILE_TYPE);
//            srcClient.setFileType(srcClient.BINARY_FILE_TYPE);
//            CreateDirecroty(targetClient, targetDir);
//            targetClient.changeWorkingDirectory(targetDir);
////            outputStream = targetClient.storeFileStream(targetDir + fileNameTemp);
//            srcClient.changeWorkingDirectory(srcDir);
//            //2.将fileAbsolutePath文件的真实文件名加.tmp上传到targetFilePath下
//            System.out.println(srcDir + fileName);
//            inputStream = srcClient.retrieveFileStream(srcDir + fileName);
//            targetClient.storeFile(targetDir + fileNameTemp, inputStream);
////            targetClient.storeFile(fileNameTemp, inputStream);
////            inputStream.close();
//            //3.将targetFilePath下与真实文件名fileName相同的文件删除,将fileName.tmp文件重命名为fileName
//            deleteFile(targetClient,targetDir, fileName);
//            System.out.println("fileNameTemp = " + fileNameTemp + ", fileName = " + fileName);
//            targetClient.rename(fileNameTemp, fileName);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            if(null != inputStream){
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    /**
     * 根据文件路径获取输入流
     * @param ftpClient
     * @param filePath 文件路径
     * */
    public InputStream getInputStream(FTPClient ftpClient, String filePath){
        try {
            return ftpClient.retrieveFileStream(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 上传文件
     * @param targetFilePath 目标文件保存地址
     *  @param inputStream 上传文件的输入流
     * @return
     */
    public void uploadFile(FTPClient ftpClient, String targetFilePath, InputStream inputStream){
        int lastIndexOfSeparator = targetFilePath.lastIndexOf("/");
        String fileName = targetFilePath.substring(lastIndexOfSeparator + 1);//获得目标文件名称
        String targetDir = targetFilePath.substring(0, lastIndexOfSeparator);
        String fileNameTemp = fileName + ".tmp";
        String fileNameTempFilePath = targetFilePath = ".tmp";
        try{
            //1.删除targetFilePath下文件名为fileName.tmp的文件,如fund_inc.js就是fund_inc.js.tmp
            deleteFile(ftpClient, targetFilePath, fileNameTemp);
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(ftpClient, targetDir);
            ftpClient.makeDirectory(targetDir);
            ftpClient.changeWorkingDirectory(targetDir);
            //2.将fileAbsolutePath文件的真实文件名加.tmp上传到targetFilePath下
            ftpClient.storeFile(fileNameTemp, inputStream);
            inputStream.close();
            //3.将targetFilePath下与真实文件名fileName相同的文件删除,将fileName.tmp文件重命名为fileName
            ftpClient.deleteFile(fileNameTempFilePath);
            ftpClient.rename(fileNameTemp, fileName);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //改变目录路径
    public boolean changeWorkingDirectory(FTPClient ftpClient, String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("进入文件夹:" + directory + " 成功！");

            } else {
                System.out.println("进入文件夹:" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public boolean CreateDirecroty(FTPClient ftpClient, String remote) throws IOException {
        boolean success = true;
        String directory = remote;
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(ftpClient, new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + subDirectory;
                if (!existFile(ftpClient, path)) {
                    if (makeDirectory(ftpClient, subDirectory)) {
                        changeWorkingDirectory(ftpClient, subDirectory);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(ftpClient, subDirectory);
                    }
                } else {
                    changeWorkingDirectory(ftpClient, subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //判断ftp服务器文件是否存在
    public boolean existFile(FTPClient ftpClient, String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }
    //创建目录
    public boolean makeDirectory(FTPClient ftpClient, String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");

            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /** * 删除文件 *
     * @param pathname FTP服务器保存目录 *
     * @param filename 要删除的文件名称 *
     * @return */
    public boolean deleteFile(FTPClient ftpClient, String pathname, String filename){
        boolean flag = false;
        try {
            System.out.println("开始删除文件：" + filename);
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            flag = true;
            System.out.println("删除文件：" + filename + "成功");
        } catch (Exception e) {
            System.out.println("删除文件：" + filename + "失败");
            e.printStackTrace();
        }
        return flag;
    }
}