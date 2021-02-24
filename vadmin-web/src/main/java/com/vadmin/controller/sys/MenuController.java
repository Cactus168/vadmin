package com.vadmin.controller.sys;

import com.vadmin.common.annotation.Log;
import com.vadmin.common.utils.DateUtils;
import com.vadmin.controller.BaseController;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.Menu;
import com.vadmin.router.Router;
import com.vadmin.service.base.BaseService;
import com.vadmin.service.sys.MenuService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单管理Controller
 * @auther: Grug
 * @date: 2020/7/31 17:33
 */
@RestController
@RequestMapping("sys/menu")
@Log(moduleName = "菜单管理")
public class MenuController extends BaseController<Menu, Long> {

    @Resource
    public MenuService menuService;

    @Override
    protected BaseService<Menu, Long> service() {
        return this.menuService;
    }
}
