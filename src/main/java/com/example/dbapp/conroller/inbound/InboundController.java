package com.example.dbapp.conroller.inbound;

import com.example.dbapp.common.dao.base.ProductMapper;
import com.example.dbapp.common.dao.base.UserMapper;
import com.example.dbapp.common.dto.base.Product;
import com.example.dbapp.common.dto.base.User;
import com.example.dbapp.common.dto.base.UserExample;
import com.example.dbapp.delegator.ProductDelegator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@MapperScan(basePackages = {"com.example.dbapp.mapper"})
@RequestMapping("/inbound")
@Controller
public class InboundController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductDelegator productDelegator;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<Product> products = productDelegator.createProductDelegator();
        UserExample ex = null;
        List<User> user = userMapper.selectByExample(ex);
        String name = user.get(0).getName();
        System.out.println(name);
        ModelAndView model = new ModelAndView("/product/list");
        model.addObject("products", products);
        return model;
    }

    @RequestMapping("/input")
    public ModelAndView input() {
        List<Product> products = productDelegator.createProductDelegator();
        UserExample ex = null;
        List<User> user = userMapper.selectByExample(ex);
        String name = user.get(0).getName();
        System.out.println(name);
        ModelAndView model = new ModelAndView("/inbound/input");
        model.addObject("products", products);
        return model;
    }

    @PostMapping(value = "/addCount")
    public ModelAndView inboundProduct(@RequestParam("id") int id, @RequestParam("count") int count) {
        // 商品を取得
        Product product = productMapper.selectByPrimaryKey(id);

        if (product == null) {
            // 商品が見つからない場合のエラーハンドリング
            ModelAndView errorModelAndView = new ModelAndView("error");
            errorModelAndView.addObject("message", "指定された商品が見つかりませんでした。");
            return errorModelAndView;
        }

//        // 減らす数がカウントを超えないように確認 これは出荷用のメモに取っておく
//        if (product.getCount() < count) {
//            ModelAndView errorModelAndView = new ModelAndView("error");
//            errorModelAndView.addObject("message", "指定されたカウントが在庫を超えています。");
//            return errorModelAndView;
//        }

        // 商品のカウントを増やす
        product.setCount(product.getCount() + count);
        productMapper.updateByPrimaryKeySelective(product);

        // 成功時のリダイレクト
        ModelAndView modelAndView = new ModelAndView("redirect:/product/list");
        return modelAndView;
    }


}
