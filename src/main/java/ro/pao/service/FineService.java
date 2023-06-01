package ro.pao.service;

import ro.pao.model.Fine;

public sealed interface FineService extends Service<Fine> permits FineServiceImpl {
}
