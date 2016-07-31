/*
 * Copyright (c) 2016. Mary (Mary_zi@outlook.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mary.eventbusdemo.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * Log工具，类似android.util.Log。
 * tag自动产生，格式: customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。
 * Author: Mary
 * Date: 16-06-30
 * Time: 下午14:40
 */
public class LogUtil {
	/** TAG 前缀 */
	public static String customTagPrefix = "LSZ_LOG";
	/** 调试模式 */
    private static boolean debug = true;
    /** 屏蔽构造方法 */
    private LogUtil() {}

    /**
     * 自动生成标识符
     * @return	标识符
     */
    private static String generateTag() {
    	// 获取调用者(类信息)
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        
        // 格式化字符串
        String tag = "%s.%s(L:%d)";
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }
    
    /**
     * 设置调试模式
     * @param debug	调试模式
     */
    public static void setDebug(boolean debug) {
    	LogUtil.debug = debug;
    }

    /////////////////// TODO 以下均为输出模式  ///////////////////
    
    public static void i(String format, Object...objects) {
    	if (!debug) return;
    	String tag = generateTag();
    	Log.i(tag, String.format(format, objects));
    }
    
    public static void i(Throwable tr, String format, Object...objects) {
    	if (!debug) return;
    	String tag = generateTag();
    	Log.i(tag, String.format(format, objects), tr);
    }
    
    public static void d(String format, Object...objects) {
    	if (!debug) return;
    	String tag = generateTag();
    	Log.d(tag, String.format(format, objects));
    }
    
    public static void d(Throwable tr, String format, Object...objects) {
    	if (!debug) return;
    	String tag = generateTag();
    	Log.d(tag, String.format(format, objects), tr);
    }
    
    public static void e(String format, Object...objects) {
    	if (!debug) return;
    	String tag = generateTag();
    	Log.e(tag, String.format(format, objects));
    }
    
    public static void e(Throwable tr, String format, Object...objects) {
    	if (!debug) return;
    	String tag = generateTag();
    	Log.e(tag, String.format(format, objects), tr);
    }
    
    public static void d(String content) {
        if (!debug) return;
        String tag = generateTag();

        Log.d(tag, content);
    }

    public static void d(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.d(tag, content, tr);
    }

    public static void e(String content) {
        if (!debug) return;
        String tag = generateTag();

        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.e(tag, content, tr);
    }

    public static void i(String content) {
        if (!debug) return;
        String tag = generateTag();

        Log.i(tag, content);
    }

    public static void i(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.i(tag, content, tr);
    }

    public static void v(String content) {
        if (!debug) return;
        String tag = generateTag();

        Log.v(tag, content);
    }

    public static void v(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.v(tag, content, tr);
    }

    public static void w(String content) {
        if (!debug) return;
        String tag = generateTag();

        Log.w(tag, content);
    }

    public static void w(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.w(tag, content, tr);
    }

    public static void w(Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.w(tag, tr);
    }


    public static void wtf(String content) {
        if (!debug) return;
        String tag = generateTag();

        Log.wtf(tag, content);
    }

    public static void wtf(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.wtf(tag, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!debug) return;
        String tag = generateTag();

        Log.wtf(tag, tr);
    }

}
