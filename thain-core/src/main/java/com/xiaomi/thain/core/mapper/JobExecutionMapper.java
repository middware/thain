/*
 * Copyright (c) 2019, Xiaomi, Inc.  All rights reserved.
 * This source code is licensed under the Apache License Version 2.0, which
 * can be found in the LICENSE file in the root directory of this source tree.
 */
package com.xiaomi.thain.core.mapper;

import com.xiaomi.thain.common.model.JobExecutionModel;
import lombok.NonNull;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Date 19-5-17 下午5:22
 *
 * @author liangyongrui@xiaomi.com
 */
public interface JobExecutionMapper {

    int add(@NonNull JobExecutionModel jobExecutionModel);

    int updateLogs(@Param("jobExecutionId") long jobExecutionId, @NonNull @Param("logs") String logs);

    int updateStatus(@Param("jobExecutionId") long jobExecutionId, @Param("status") int status);

    int updateCreateTime(@Param("jobExecutionId") long jobExecutionId);

    int killJobExecution(long flowExecutionId);

    /**
     * 根据flowExecutionId 删除 job execution
     *
     * @param flowExecutionIds flowExecutionIds
     * @return ignore
     */
    int deleteJobExecutionByFlowExecutionIds(@NonNull List<Long> flowExecutionIds);

    int cleanUpExpiredFlowExecution(int dataReserveDays);
}
