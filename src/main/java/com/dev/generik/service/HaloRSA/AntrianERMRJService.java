package com.dev.generik.service.HaloRSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AntrianERMRJService {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String API_LOGIN =
            "http://192.168.1.9:8006/api/login";

    private static final String API_QUEUE =
            "http://192.168.1.9:8006/api/doctor-queues/today-grouped";

    public Map<String, Long> getTotalTerlayaniMap() {
        Map<String, Long> result = new HashMap<>();

        try {
            String token = loginAndGetToken();

            if (token == null) {
                System.out.println("Gagal login antrean eksternal");
                return result;
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(token);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Map<String, Object>> response =
                    restTemplate.exchange(
                            API_QUEUE,
                            HttpMethod.GET,
                            entity,
                            new ParameterizedTypeReference<Map<String, Object>>() {}
                    );

            Map<String, Object> body = castMap(response.getBody());
            if (body == null) return result;

            List<Map<String, Object>> data = castListMap(body.get("data"));
            if (data == null) return result;

            for (Map<String, Object> specialist : data) {
                List<Map<String, Object>> doctors =
                        castListMap(specialist.get("doctors"));

                if (doctors == null) continue;

                for (Map<String, Object> doctor : doctors) {
                    Number doctorId = castNumber(doctor.get("doctor_id"));
                    String shift = String.valueOf(doctor.get("shift"));

                    Map<String, Object> aggregate =
                            castMap(doctor.get("aggregate"));

                    if (doctorId == null || aggregate == null) continue;

                    Number totalDipanggil =
                            castNumber(aggregate.get("total_terlayani"));

                    if (totalDipanggil == null) continue;

                    String key = doctorId.longValue() + "-" + shift;

                    result.put(key, totalDipanggil.longValue());
                }
            }

        } catch (Exception e) {
            System.out.println("Gagal ambil antrean eksternal: " + e.getMessage());
        }

        return result;
    }

    private String loginAndGetToken() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> body = new HashMap<>();
            body.put("username", "febbi");
            body.put("password", "YJ18O1rZwD3ajbaV");

            HttpEntity<Map<String, String>> entity =
                    new HttpEntity<>(body, headers);

            ResponseEntity<Map<String, Object>> response =
                    restTemplate.exchange(
                            API_LOGIN,
                            HttpMethod.POST,
                            entity,
                            new ParameterizedTypeReference<Map<String, Object>>() {}
                    );
            Map<String, Object> responseBody = castMap(response.getBody());

            if (responseBody == null) return null;

            Object token = responseBody.get("token");

            return token != null ? token.toString() : null;

        } catch (Exception e) {
            System.out.println("Gagal login antrean eksternal: " + e.getMessage());
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> castMap(Object obj) {
        if (obj instanceof Map) {
            return (Map<String, Object>) obj;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> castListMap(Object obj) {
        if (obj instanceof List) {
            return (List<Map<String, Object>>) obj;
        }
        return null;
    }

    private Number castNumber(Object obj) {
        if (obj instanceof Number) {
            return (Number) obj;
        }
        return null;
    }
}