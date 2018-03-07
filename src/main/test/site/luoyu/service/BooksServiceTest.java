package site.luoyu.service;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import site.luoyu.SpringContext;

/** 
* BooksService Tester. 
* 
* @author <Authors name> 
* @since <pre>3/7/2018</pre>
* @version 1.0 
*/ 
public class BooksServiceTest extends SpringContext{

    @Autowired
    private BooksService bs;

    @Before
    public void before() throws Exception {
        //mock a httpservletRequest
    }

    @After
    public void after() throws Exception {
    }


    /**
    *
    * Method: publishBook(Map bookParameter, List<String> path, User user)
    *
    */
    @Test
    public void testPublishBook() throws Exception {
//        bs.publishBook();
    }

    /**
    *
    * Method: uploadCover(HttpServletRequest request, User user, Map<String,MultipartFile> fileMap)
    *
    */
    @Test
    public void testUploadCover() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: findBySort(Sort sort)
    *
    */
    @Test
    public void testFindBySort() throws Exception {
    //TODO: Test goes here...
    }


} 
