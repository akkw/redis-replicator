/*
 * Copyright 2016-2018 Leon Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.impl;

import java.util.Map;

import com.moilioncircle.redis.replicator.cmd.CommandSpec;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
@CommandSpec(command = "MSET")
public class MSetCommand extends AbstractCommand {

    private static final long serialVersionUID = 1L;

    private Map<byte[], byte[]> kv;

    public MSetCommand() {
    }

    public MSetCommand(Map<byte[], byte[]> kv) {
        this.kv = kv;
    }

    public Map<byte[], byte[]> getKv() {
        return kv;
    }

    public void setKv(Map<byte[], byte[]> kv) {
        this.kv = kv;
    }
}
