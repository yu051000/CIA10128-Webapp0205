package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration //替換xml的設定方式
@EnableWebSocket //啟用WebSocket
public class WsConfig {

    @Bean
    public ServerEndpointExporter saverEndpoint() {
        return new ServerEndpointExporter();
    }

}
