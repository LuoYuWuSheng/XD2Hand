package site.luoyu.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.luoyu.dao.entity.Books;
import site.luoyu.dao.mapper.BooksMapper;
import site.luoyu.model.UserModel;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.*;


/**
 * Created by luoyu on 2018/3/7.
 */
@Service
public class BooksService {

    //日志
    private static final Logger log = LogManager.getLogger(BooksService.class);

    @Autowired
    BooksMapper booksMapper;

    /**
     * 分页查询
     */
    @Transactional
    public List<Books> getBooksByPage(){
    	List<Books> page = booksMapper.getBooks();
    	return page;
    }


    public void recommendBooks(){}

    /**
     * 图书发布
     * @param bookParameter
     *     客户端传过来的图书参数
     * @param userModel
     *     发布图书人的信息
     */
    public void publishBook(Map bookParameter,MultipartHttpServletRequest multipartHttpServletRequest,
                            UserModel userModel) throws IOException {
        String imgType = ((String[]) bookParameter.get("imgType"))[0];
        List<String> path;
        if(imgType.equals("file")){
            Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
            //上传图片封面，并将路径信息保存到数据库
            path = uploadCover(multipartHttpServletRequest, userModel, fileMap);
        }else {
            //url不入库。。
            path=new ArrayList<>(1);
            path.add(((String[]) bookParameter.get("url"))[0]);
        }
        Books aBook = new Books();
        aBook.setUserId(userModel.getStuId());
        aBook.setPublishDate(new Date(System.currentTimeMillis()));
        // id 自增
//        book.setBookId(UUID.randomUUID().);
        aBook.setTitle(((String[]) bookParameter.get("title"))[0]);
        aBook.setPrice(Float.parseFloat(((String[]) bookParameter.get("price"))[0]));
        aBook.setSubtitle(((String[]) bookParameter.get("subtitle"))[0]);
        aBook.setDetail(((String[]) bookParameter.get("detail"))[0]);
        aBook.setNum(0
        );
        //存储图片
        aBook.setPictures(path.get(0));
        log.info("图书发布持久化 书名: " + aBook.getTitle());
        booksMapper.insert(aBook);
    }
    
    /*
     *上传图书封面图片 
     */
    public List<String> uploadCover(MultipartHttpServletRequest request, UserModel userModel, Map<String, MultipartFile> fileMap) throws IOException {
          List<String> imageURI = new ArrayList<>();
          //todo windows linxu 路径表示不同，这里不同系统会与问题
    	  String realPath = request.getSession().getServletContext().getRealPath("/")+"uploadImages"+"/";
          File file = new File(realPath);
          //将不同用户上传的图片放到不同的目录下，目录名为用户id
          String userPath = realPath + userModel.getStuId()+"/";
          File userFile = new File(userPath);
          if(!file.exists()){
        	  file.mkdir();
          }
          if (!userFile.exists()) {
			  userFile.mkdir();
          }
          String bookImageURI = null;
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();
            bookImageURI = UUID.randomUUID().toString();
        	  String filePath = userPath + bookImageURI;
              //拼写上传图片在web服务器下的路径
              bookImageURI = "/uploadImages/"+ userModel.getStuId()+"/"+bookImageURI;
        	  File uploadFile = new File(filePath);
              mf.transferTo(uploadFile);
        	  //FileCopyUtils.copy(mf.getBytes(), uploadFile);
        	  imageURI.add(bookImageURI);
        	
          }
         return imageURI;
    }

    /**
     * 获取一本书详情
     * @param id 书本id
     * @return 返回该书本
     */
    public Books getBookById(int id){
        return booksMapper.selectByPrimaryKey(id);
    }

    /**
     * todo 没判断是否更新成功
     * @param book 待更新的数据
     * @return 是否成功
     */
    public boolean updateBook(Books book,MultipartHttpServletRequest multipartHttpServletRequest,
                               UserModel userModel ) throws IOException {
        Map bookParameter = multipartHttpServletRequest.getParameterMap();
        book.setPublishDate(new java.util.Date(System.currentTimeMillis()));

        String imgType = ((String[]) bookParameter.get("imgType"))[0];
        List<String> path;
        if(imgType.equals("file")){
            Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
            //上传图片封面，并将路径信息保存到数据库
            path = uploadCover(multipartHttpServletRequest, userModel, fileMap);
        }else {
            //url不入库。。
            path=new ArrayList<>(1);
            path.add(((String[]) bookParameter.get("url"))[0]);
        }
        //存储图片
        book.setPictures(path.get(0));
        log.info("图书编辑持久化 书名: " + book.getTitle());
        booksMapper.updateByPrimaryKey(book);
        return true;
    }

    public boolean delete(int bookId){
        booksMapper.deleteByPrimaryKey(bookId);
        return true;
    }

    /**
     * 获取畅销书
     * @return
     */
    public List<Books> topRate(){
        return booksMapper.rate();
    }

    /**
     * 搜索，没有分词，只是简单的like
     * @param name
     * @return
     */
    public List<Books> search(String name){
        return booksMapper.searchLike(name);
    }
}
