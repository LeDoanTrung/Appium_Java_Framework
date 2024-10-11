package com.core.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestHelper implements IRetryAnalyzer {
        private int count = 0;
        private static final int MAX_RETRY_COUNT = 3;

        @Override
        public boolean retry(ITestResult iTestResult) {
            if (!iTestResult.isSuccess()) {
                if (count < MAX_RETRY_COUNT) {
                    count++;
                    iTestResult.setStatus(ITestResult.FAILURE);
                    return true;
                }
            }
            return false;
        }
}
