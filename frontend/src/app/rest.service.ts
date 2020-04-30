export interface RestService<T> {
  SERVER_URL: string;

  getAll(): T[];

  get(id: string): T;

  post(resource: T): T;

  delete(id: string): T;
}
