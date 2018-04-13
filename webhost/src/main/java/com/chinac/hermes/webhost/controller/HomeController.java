package com.chinac.hermes.webhost.controller;

import com.chinac.hermes.webhost.dto.Hello;
import com.chinac.hermes.webhost.dto.ReturnData;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "HomeController", description = "Home相关的API")
public class HomeController {

    @RequestMapping(value = "/home/hello", method = RequestMethod.GET)
    @ApiOperation(value = "sayHello", notes = "sayHello的API", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String", example = "name=\"我去\""),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "Integer", example = "age=12")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "服务端错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public @ResponseBody
    ReturnData<Hello> sayHello(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "age", required = false) Integer age) {
        Hello hello = new Hello();

        hello.setAge(age == null ? 12 : age);
        hello.setName(StringUtils.isEmpty(name) ? "woqu" : name);

        return new ReturnData<>(hello);
    }

    @RequestMapping(value = "/home/helloComplex", method = RequestMethod.GET)
    @ApiOperation(value = "sayHelloComplex",
            notes = "sayHelloComplex的API",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String", example = "name=\"我去\""),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", example = "age=12")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "服务端错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public @ResponseBody
    ReturnData<List<Hello>> sayHelloComplex(@RequestParam(value = "name", required = false) String name,
                                            @RequestParam(value = "age", required = false) Integer age) {
        Hello hello = new Hello();

        hello.setAge(age == null ? 12 : age);
        hello.setName(StringUtils.isEmpty(name) ? "woqu" : name);
        ArrayList<Hello> list = new ArrayList<>();
        list.add(hello);

        return new ReturnData<>(list);
    }

    @RequestMapping(value = "/home/helloComplex1", method = RequestMethod.POST)
    @ApiOperation(value = "sayHelloComplex1",
            notes = "sayHelloComplex2的API",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )

    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "服务端错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public @ResponseBody
    ReturnData<List<Hello>> sayHelloComplex1(@RequestBody List<Hello> woqu,
                                             @RequestParam(value = "age", required = false) Integer age) {
        Hello hello = new Hello();

        hello.setAge(age == null ? 12 : age);
        hello.setName("13213");
        ArrayList<Hello> list = new ArrayList<>();
        list.add(hello);

        return new ReturnData<>(list);
    }
}
