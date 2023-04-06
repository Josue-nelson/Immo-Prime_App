'use strict';

/**
 * logement service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::logement.logement');
