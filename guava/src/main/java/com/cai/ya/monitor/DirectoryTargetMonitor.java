package com.cai.ya.monitor;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.*;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/28 14:52
 */
@Slf4j
public class DirectoryTargetMonitor implements TargetMonitor {
    //文件监听器，通过操作系统原生文件系统来运行
    private WatchService watchService;
    //监听路径
    private final Path path;

    private volatile boolean start = false;

    public DirectoryTargetMonitor(String targetPath) {
        this.path = Paths.get(targetPath);
    }

    @Override
    public void startMonitor() throws Exception {
        //watchService实例化
        this.watchService = FileSystems.getDefault().newWatchService();
        //监控文件的 修改  增加  删除
        this.path.register(watchService,StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
        this.start =true;
        while (start){
            WatchKey watchKey = null;
            try {
                log.info("开始监控");
                //获取变化信息的监控池，没有则一直阻塞
                watchKey = watchService.take();
                //获取事件列表
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                log.info("获取事件");
                for (WatchEvent<?> watchEvent : watchEvents) {
                    //监听事件类型
                    WatchEvent.Kind<?> kind = watchEvent.kind();
                    //得到监听文件的路径(文件名)
                    Path name =(Path) watchEvent.context();
                    //获取全路径 path + name
                    Path allPath = this.path.resolve(name);
                    log.info("{}:{}:{}",kind,allPath,name);
                }
            } catch (Exception e) {
                System.out.println("被打断");
                e.printStackTrace();
                this.start =false;
            } finally {
                //每次得到新事件后，都需要重置
                if (watchKey != null) watchKey.reset();
            }
        }
    }

    @Override
    public void stopMonitor() throws Exception {
        log.info("目录 {} 将要关闭监听",path);
        this.start = false;
        this.watchService.close();
        log.info("目录 {} 已经关闭监听",path);

    }
}
