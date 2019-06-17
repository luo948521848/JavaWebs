package com.easybuy.EasybuyProduct;


import com.easybuy.entity.EasybuyNews;
import com.easybuy.entity.EasybuyProduct;
import com.easybuy.other.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//用于处理 商品类型
@Controller
public class EasyBuyProductController {

@Autowired
EasybuyProductService easybuyProductService;

    //进入首页
    //查询商品类型与 其子类级别
    //获取购物车、新闻内容



    //根据parentID进行查询

   @RequestMapping ("/Home")

    public String gohome(HttpServletRequest request, @RequestParam String action)throws  Exception
   {
       request.setCharacterEncoding("utf-8");


       if ("index".equals(action)) {
           //加载主页类容
           //查询新闻
           List<EasybuyNews> list = easybuyProductService.listnews();
           System.out.println("广告规模"+list.size());
           //查询商品商品种类和它8个商品

           List <EasyBuyProductsVo> list1 =easybuyProductService.listbyparentid();

           System.out.println( ""+list1.size());
           //查询一楼
           int i=1;
           for (EasyBuyProductsVo vo: list1) {

               List<EasybuyProduct>productList1=easybuyProductService.geteigth(vo.getProductCategory().getId());
              // System.out.println("商品规模"+productList1.size());
               request.setAttribute("productList",productList1);
               vo.setProductList(productList1);
               i++;
           }


           //封装返回
           request.setAttribute("productCategoryVoList", list1);
           request.setAttribute("news", list);
           return "/pre/index";

       }

       return "";


   }


   @RequestMapping("/Product")
    public String ProductAction(HttpServletRequest request, @RequestParam String action,@RequestParam(required = false) Integer level,
                                @RequestParam(required = false) Long category,@RequestParam(required = false ,defaultValue = "1")Integer currentPage )throws  Exception
   {

       request.setCharacterEncoding("utf-8");

       if("queryProductDeatil".equals(action))
       {
           String id=request.getParameter("id");
           EasybuyProduct easybuyProduct =easybuyProductService.getProduceByid(Long.parseLong(id));

           request.setAttribute("product",easybuyProduct);

           return "pre/product/productDeatil";
       }else if("queryProductList".equals(action))
       {

           List<EasybuyProduct>list=null;
           Pager pager =new Pager();
           Integer total=0;
           switch (level)
           {
               case 1:
                   list=easybuyProductService.getProductsBy1id(category,currentPage);
                   total=easybuyProductService.getnumsby1id(category);
                   pager.setPageCount(total/20+1);
                   break;
               case 2:
                   list=easybuyProductService.getProductsBy2id(category,currentPage);
                   total=easybuyProductService.getnumsby2id(category);
                   pager.setPageCount(total/20+1);
                   break;
               case 3:
                   list=easybuyProductService.getProductsBy3id(category,currentPage);
                   total=easybuyProductService.getnumsby3id(category);
                   pager.setPageCount(total/20+1);
                   break;

           }
           pager.setUrl("Product?action=queryProductList&level="+level+"&category="+category);
           pager.setCurrentPage(currentPage);
           request.setAttribute("pager",pager);
           request.setAttribute("productList",list);

            request.setAttribute("total",total);
            return "pre/product/queryProductList";

       }





       return "";
   }




}
